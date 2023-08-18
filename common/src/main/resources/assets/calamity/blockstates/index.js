// incase u ever need to fix everything
let names = [
    "506", "baab", "cake", "fern", "herobrine", "illuc", "ithundxr", "kolos", "milkyfur", "null", "outcraft",
    "potato", "raeeeee", "reds", "sascha", "shirojr", "spydnel", "to0pa", "tomato_soupter"
]

for(name of names) {
    require("fs").copyFileSync("plushie.json", `plushie_${name}.json`)
}