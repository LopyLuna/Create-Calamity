package com.calamityteam.calamity.mixin;

import com.simibubi.create.content.kinetics.base.KineticBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(KineticBlockEntity.class)
public interface KineticBlockEntityAccessor {
    @Accessor("stress")
    public float getStress();
    @Accessor("capacity")
    public float getMaxStress();
}
