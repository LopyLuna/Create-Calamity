package com.calamityteam.calamity;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;

import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import com.calamityteam.calamity.base.featurepack.CalamityFeaturePack;

import com.simibubi.create.foundation.data.BlockStateGen;
import com.simibubi.create.foundation.data.CreateBlockEntityBuilder;

import com.simibubi.create.foundation.data.CreateEntityBuilder;

import com.simibubi.create.foundation.data.VirtualFluidBuilder;

import org.jetbrains.annotations.Nullable;

import com.simibubi.create.Create;
import com.simibubi.create.CreateClient;
import com.simibubi.create.content.decoration.encasing.CasingConnectivity;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.simibubi.create.foundation.block.connected.CTModel;
import com.simibubi.create.foundation.block.connected.ConnectedTextureBehaviour;
import com.simibubi.create.foundation.item.TooltipModifier;
import com.simibubi.create.foundation.item.render.CustomRenderedItemModelRenderer;
import com.simibubi.create.foundation.item.render.CustomRenderedItems;
import com.simibubi.create.foundation.utility.RegisteredObjects;
import com.tterrag.registrate.AbstractRegistrate;
import com.tterrag.registrate.builders.BlockBuilder;
import com.tterrag.registrate.builders.BlockEntityBuilder.BlockEntityFactory;
import com.tterrag.registrate.builders.Builder;
import com.tterrag.registrate.builders.FluidBuilder;
import com.tterrag.registrate.builders.ItemBuilder;
import com.tterrag.registrate.fabric.EnvExecutor;
import com.tterrag.registrate.fabric.RegistryObject;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import com.tterrag.registrate.util.entry.RegistryEntry;
import com.tterrag.registrate.util.nullness.NonNullConsumer;
import com.tterrag.registrate.util.nullness.NonNullFunction;
import com.tterrag.registrate.util.nullness.NonNullSupplier;
import com.tterrag.registrate.util.nullness.NonNullUnaryOperator;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.BuiltinItemRendererRegistry;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

public class CalamityRegistrate extends AbstractRegistrate<CalamityRegistrate> {
	@Nullable
	protected Function<Item, TooltipModifier> currentTooltipModifierFactory;

	@Nullable
	protected Function<Item, CalamityFeaturePack> currentFeatureFactory;


	protected CalamityRegistrate(String modid) {
		super(modid);
	}

	public static CalamityRegistrate create(String modid) {
		return new CalamityRegistrate(modid);
	}

	public CalamityRegistrate setTooltipModifierFactory(@Nullable Function<Item, TooltipModifier> factory) {
		currentTooltipModifierFactory = factory;
		return self();
	}

	public CalamityRegistrate setFeatureFactory(@Nullable Function<Item, CalamityFeaturePack> factory) {
		currentFeatureFactory = factory;
		return self();
	}

	@Nullable
	public Function<Item, TooltipModifier> getTooltipModifierFactory() {
		return currentTooltipModifierFactory;
	}

	@Nullable
	public Function<Item, TooltipModifier> getFeatureFactory() {
		return currentTooltipModifierFactory;
	}

	@Override
	protected <R , T extends R> RegistryEntry<T> accept(String name, ResourceKey<? extends Registry<R>> type, Builder<R, T, ?, ?> builder, NonNullSupplier<? extends T> creator, NonNullFunction<RegistryObject<T>, ? extends RegistryEntry<T>> entryFactory) {
		RegistryEntry<T> entry = super.accept(name, type, builder, creator, entryFactory);
		if (type.equals(Registry.ITEM_REGISTRY)) {
			if (currentTooltipModifierFactory != null) {
				TooltipModifier.REGISTRY.registerDeferred(entry.getId(), currentTooltipModifierFactory);
			}
			if (currentFeatureFactory != null) {
				Calamity.LOGGER.info("set into" + entry.getId());
				CalamityFeaturePack.REGISTRY.registerDeferred(entry.getId(), currentFeatureFactory);
			}
		}
		return entry;
	}

	@Override
	public <T extends BlockEntity> CreateBlockEntityBuilder<T, CalamityRegistrate> blockEntity(String name,
																							 BlockEntityFactory<T> factory) {
		return blockEntity(self(), name, factory);
	}

	@Override
	public <T extends BlockEntity, P> CreateBlockEntityBuilder<T, P> blockEntity(P parent, String name,
																				 BlockEntityFactory<T> factory) {
		return (CreateBlockEntityBuilder<T, P>) entry(name,
			(callback) -> CreateBlockEntityBuilder.create(this, parent, name, callback, factory));
	}

	@Override
	public <T extends Entity> CreateEntityBuilder<T, CalamityRegistrate> entity(String name,
																			  EntityType.EntityFactory<T> factory, MobCategory classification) {
		return this.entity(self(), name, factory, classification);
	}

	@Override
	public <T extends Entity, P> CreateEntityBuilder<T,  P> entity(P parent, String name,
																   EntityType.EntityFactory<T> factory, MobCategory classification) {
		return (CreateEntityBuilder<T, P>) this.entry(name, (callback) -> {
			return CreateEntityBuilder.create(this, parent, name, callback, factory, classification);
		});
	}

	/* Palettes */

	public <T extends Block> BlockBuilder<T, CalamityRegistrate> paletteStoneBlock(String name,
																				 NonNullFunction<Properties, T> factory, NonNullSupplier<Block> propertiesFrom, boolean worldGenStone,
																				 boolean hasNaturalVariants) {
		BlockBuilder<T, CalamityRegistrate> builder = super.block(name, factory).initialProperties(propertiesFrom)
			.transform(pickaxeOnly())
			.blockstate(hasNaturalVariants ? BlockStateGen.naturalStoneTypeBlock(name) : (c, p) -> {
				final String location = "block/palettes/stone_types/" + c.getName();
				p.simpleBlock(c.get(), p.models()
					.cubeAll(c.getName(), p.modLoc(location)));
			})
			.tag(BlockTags.DRIPSTONE_REPLACEABLE)
			.tag(BlockTags.AZALEA_ROOT_REPLACEABLE)
			.tag(BlockTags.MOSS_REPLACEABLE)
			.tag(BlockTags.LUSH_GROUND_REPLACEABLE)
			.item()
			.model((c, p) -> p.cubeAll(c.getName(),
				p.modLoc(hasNaturalVariants ? "block/palettes/stone_types/natural/" + name + "_1"
					: "block/palettes/stone_types/" + c.getName())))
			.build();
		return builder;
	}

	public BlockBuilder<Block, CalamityRegistrate> paletteStoneBlock(String name, NonNullSupplier<Block> propertiesFrom,
																   boolean worldGenStone, boolean hasNaturalVariants) {
		return paletteStoneBlock(name, Block::new, propertiesFrom, worldGenStone, hasNaturalVariants);
	}

	/* Fluids */

	public <T extends SimpleFlowableFluid> FluidBuilder<T, CalamityRegistrate> virtualFluid(String name,
//		BiFunction<FluidAttributes.Builder, Fluid, FluidAttributes> attributesFactory,
																						  NonNullFunction<SimpleFlowableFluid.Properties, T> factory) {
		return entry(name,
			c -> new VirtualFluidBuilder<>(self(), self(), name, c, Create.asResource("fluid/" + name + "_still"),
				Create.asResource("fluid/" + name + "_flow"), /*attributesFactory, */factory));
	}

	public <T extends SimpleFlowableFluid> FluidBuilder<T, CalamityRegistrate> virtualFluid(String name, ResourceLocation still, ResourceLocation flow,
//																						BiFunction<FluidAttributes.Builder, Fluid, FluidAttributes> attributesFactory,
																						  NonNullFunction<SimpleFlowableFluid.Properties, T> factory) {
		return entry(name,
			c -> new VirtualFluidBuilder<>(self(), self(), name, c, still,
				flow, factory));
	}

	public FluidBuilder<VirtualFluid, CalamityRegistrate> virtualFluid(String name) {
		return entry(name,
			c -> new VirtualFluidBuilder<>(self(), self(), name, c, Create.asResource("fluid/" + name + "_still"),
				Create.asResource("fluid/" + name + "_flow"), /*null, */VirtualFluid::new));
	}

	public FluidBuilder<VirtualFluid, CalamityRegistrate> virtualFluid(String name, ResourceLocation still, ResourceLocation flow) {
		return entry(name,
			c -> new VirtualFluidBuilder<>(self(), self(), name, c, still,
				flow, VirtualFluid::new));
	}

	public FluidBuilder<SimpleFlowableFluid.Flowing, CalamityRegistrate> standardFluid(String name) {
		return fluid(name, Create.asResource("fluid/" + name + "_still"), Create.asResource("fluid/" + name + "_flow"));
	}

/*
	public FluidBuilder<ForgeFlowingFluid.Flowing, CalamityRegistrate> standardFluid(String name,
		FluidBuilder.FluidTypeFactory typeFactory) {
		return fluid(name, Create.asResource("fluid/" + name + "_still"), Create.asResource("fluid/" + name + "_flow"),
			typeFactory);
	}

	public static FluidType defaultFluidType(FluidType.Properties properties, ResourceLocation stillTexture,
		ResourceLocation flowingTexture) {
		return new FluidType(properties) {
			@Override
			public void initializeClient(Consumer<IClientFluidTypeExtensions> consumer) {
				consumer.accept(new IClientFluidTypeExtensions() {
					@Override
					public ResourceLocation getStillTexture() {
						return stillTexture;
					}

					@Override
					public ResourceLocation getFlowingTexture() {
						return flowingTexture;
					}
				});
			}
		};
	}
*/
	/* Util */

	public static <T extends Block> NonNullConsumer<? super T> casingConnectivity(
		BiConsumer<T, CasingConnectivity> consumer) {
		return entry -> onClient(() -> () -> registerCasingConnectivity(entry, consumer));
	}

	public static <T extends Block> NonNullConsumer<? super T> blockModel(
		Supplier<NonNullFunction<BakedModel, ? extends BakedModel>> func) {
		return entry -> onClient(() -> () -> registerBlockModel(entry, func));
	}

	public static <T extends Item> NonNullConsumer<? super T> itemModel(
		Supplier<NonNullFunction<BakedModel, ? extends BakedModel>> func) {
		return entry -> onClient(() -> () -> registerItemModel(entry, func));
	}

	public static <T extends Block> NonNullConsumer<? super T> connectedTextures(
		Supplier<ConnectedTextureBehaviour> behavior) {
		return entry -> onClient(() -> () -> registerCTBehviour(entry, behavior));
	}

	public static <T extends Item, P> NonNullUnaryOperator<ItemBuilder<T, P>> customRenderedItem(
		Supplier<Supplier<CustomRenderedItemModelRenderer>> supplier) {
		return b -> {
			onClient(() -> () -> customRenderedItem(b, supplier));
			return b;
		};
	}

	protected static void onClient(Supplier<Runnable> toRun) {
		EnvExecutor.runWhenOn(EnvType.CLIENT, toRun);
	}

	@Environment(EnvType.CLIENT)
	private static <T extends Block> void registerCasingConnectivity(T entry,
																	 BiConsumer<T, CasingConnectivity> consumer) {
		consumer.accept(entry, CreateClient.CASING_CONNECTIVITY);
	}

	@Environment(EnvType.CLIENT)
	private static void registerBlockModel(Block entry,
										   Supplier<NonNullFunction<BakedModel, ? extends BakedModel>> func) {
		CreateClient.MODEL_SWAPPER.getCustomBlockModels()
			.register(RegisteredObjects.getKeyOrThrow(entry), func.get());
	}

	@Environment(EnvType.CLIENT)
	private static void registerItemModel(Item entry,
										  Supplier<NonNullFunction<BakedModel, ? extends BakedModel>> func) {
		CreateClient.MODEL_SWAPPER.getCustomItemModels()
			.register(RegisteredObjects.getKeyOrThrow(entry), func.get());
	}

	@Environment(EnvType.CLIENT)
	private static void registerCTBehviour(Block entry, Supplier<ConnectedTextureBehaviour> behaviorSupplier) {
		ConnectedTextureBehaviour behavior = behaviorSupplier.get();
		CreateClient.MODEL_SWAPPER.getCustomBlockModels()
			.register(RegisteredObjects.getKeyOrThrow(entry), new CTModelProvider(behavior));
	}



	@Environment(EnvType.CLIENT)
	private static <T extends Item, P> void customRenderedItem(ItemBuilder<T, P> b,
															   Supplier<Supplier<CustomRenderedItemModelRenderer>> supplier) {
		b.onRegister(new CustomRendererRegistrationHelper(supplier));
	}

	// fabric: these records are required jank since @Environment doesn't strip lambdas

	@Environment(EnvType.CLIENT)
	private record CTModelProvider(ConnectedTextureBehaviour behavior) implements NonNullFunction<BakedModel, BakedModel> {
		@Override
		public BakedModel apply(BakedModel bakedModel) {
			return new CTModel(bakedModel, behavior);
		}
	}

	@Environment(EnvType.CLIENT)
	private record CustomRendererRegistrationHelper(Supplier<Supplier<CustomRenderedItemModelRenderer>> supplier) implements NonNullConsumer<Item> {
		@Override
		public void accept(Item entry) {
			CustomRenderedItemModelRenderer renderer = supplier.get().get();
			BuiltinItemRendererRegistry.INSTANCE.register(entry, renderer);
			CustomRenderedItems.register(entry);
		}
	}
}
