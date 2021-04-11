package org.kryptonmc.krypton.api.inventory.item

import net.kyori.adventure.util.Index
import org.kryptonmc.krypton.api.Keyed
import org.kryptonmc.krypton.api.registry.NamespacedKey

/**
 * The list of types of items.
 *
 * The ordering of this enum is based off of the [official Minecraft wiki](https://minecraft.gamepedia.com/Item#List_of_items)'s ordering
 *
 * @author Callum Seabrook
 */
enum class Material(internalKey: NamespacedKey? = null) : Keyed {

    /**
     * Items that create blocks, fluids or entities
     */
    ACACIA_BOAT,
    ARMOR_STAND,
    BEETROOT_SEEDS,
    BIRCH_BOAT,
    BOTTLE_OF_ENCHANTING(NamespacedKey(value = "experience_bottle")),
    BOW,
    BUCKET,
    BUCKET_OF_COD(NamespacedKey(value = "cod_bucket")),
    BUCKET_OF_PUFFERFISH(NamespacedKey(value = "pufferfish_bucket")),
    BUCKET_OF_SALMON(NamespacedKey(value = "salmon_bucket")),
    BUCKET_OF_TROPICAL_FISH(NamespacedKey(value = "tropical_fish_bucket")),
    CARROT(NamespacedKey(value = "carrot")),
    COCOA_BEANS,
    CROSSBOW,
    DARK_OAK_BOAT,
    EGG,
    END_CRYSTAL,
    ENDER_PEARL,
    EYE_OF_ENDER(NamespacedKey(value = "ender_eye")),
    FIRE_CHARGE,
    FIREWORK_ROCKET,
    FISHING_ROD,
    FLINT_AND_STEEL,
    ITEM_FRAME,
    JUNGLE_BOAT,
    KELP,
    LAVA_BUCKET,
    LEAD,
    MELON_SEEDS,
    MINECART,
    MINECART_WITH_CHEST(NamespacedKey(value = "chest_minecart")),
    MINECART_WITH_COMMAND_BLOCK(NamespacedKey(value = "command_block_minecart")),
    MINECART_WITH_FURNACE(NamespacedKey(value = "furnace_minecart")),
    MINECART_WITH_HOPPER(NamespacedKey(value = "hopper_minecart")),
    MINECART_WITH_TNT(NamespacedKey(value = "tnt_minecart")),
    NETHER_WART,
    OAK_BOAT,
    PAINTING,
    POTATO,
    POWDER_SNOW_BUCKET,
    PUMPKIN_SEEDS,
    REDSTONE_DUST(NamespacedKey(value = "redstone")),
    SNOWBALL,
    SPRUCE_BOAT,
    STRING,
    SWEET_BERRIES,
    TRIDENT,
    WATER_BUCKET,
    WHEAT_SEEDS,

    /**
     * Items with use in the world
     */
    APPLE,
    ARROW,
    BAKED_POTATO,
    BEETROOT,
    BEETROOT_SOUP,
    BLACK_DYE,
    BLUE_DYE,
    BONE,
    BONE_MEAL,
    BOOK_AND_QUILL(NamespacedKey(value = "writable_book")),
    BOWL,
    BREAD,
    BROWN_DYE,
    CARROT_ON_A_STICK,
    CHAINMAIL_BOOTS,
    CHAINMAIL_CHESTPLATE,
    CHAINMAIL_HELMET,
    CHAINMAIL_LEGGINGS,
    CHORUS_FRUIT,
    COMPASS,
    COOKED_CHICKEN,
    COOKED_COD,
    COOKED_MUTTON,
    COOKED_PORKCHOP,
    COOKED_RABBIT,
    COOKED_SALMON,
    COOKIE,
    CYAN_DYE,
    DEBUG_STICK,
    DIAMOND_AXE,
    DIAMOND_BOOTS,
    DIAMOND_CHESTPLATE,
    DIAMOND_HELMET,
    DIAMOND_HOE,
    DIAMOND_HORSE_ARMOR,
    DIAMOND_LEGGINGS,
    DIAMOND_PICKAXE,
    DIAMOND_SHOVEL,
    DIAMOND_SWORD,
    DRIED_KELP,
    ELYTRA,
    EMPTY_MAP(NamespacedKey(value = "map")),
    ENCHANTED_GOLDEN_APPLE,
    GLASS_BOTTLE,
    GOLD_INGOT,
    GOLDEN_APPLE,
    GOLDEN_AXE,
    GOLDEN_BOOTS,
    GOLDEN_CARROT,
    GOLDEN_CHESTPLATE,
    GOLDEN_HELMET,
    GOLDEN_HOE,
    GOLDEN_HORSE_ARMOR,
    GOLDEN_LEGGINGS,
    GOLDEN_PICKAXE,
    GOLDEN_SHOVEL,
    GOLDEN_SWORD,
    GRAY_DYE,
    GREEN_DYE,
    HONEY_BOTTLE,
    IRON_AXE,
    IRON_BOOTS,
    IRON_CHESTPLATE,
    IRON_HELMET,
    IRON_HOE,
    IRON_HORSE_ARMOR,
    IRON_LEGGINGS,
    IRON_PICKAXE,
    IRON_SHOVEL,
    IRON_SWORD,
    KNOWLEDGE_BOOK,
    LEATHER_BOOTS,
    LEATHER_CAP(NamespacedKey(value = "leather_helmet")),
    LEATHER_HORSE_ARMOR,
    LEATHER_PANTS(NamespacedKey(value = "leather_leggings")),
    LEATHER_TUNIC(NamespacedKey(value = "leather_chestplate")),
    LIGHT_BLUE_DYE,
    LIGHT_GRAY_DYE,
    LIME_DYE,
    MAGENTA_DYE,
    MAP(NamespacedKey(value = "filled_map")),
    MELON_SLICE,
    MILK_BUCKET,
    MUSHROOM_STEW,
    MUSIC_DISC_11,
    MUSIC_DISC_13,
    MUSIC_DISC_BLOCKS,
    MUSIC_DISC_CAT,
    MUSIC_DISC_CHIRP,
    MUSIC_DISC_FAR,
    MUSIC_DISC_MALL,
    MUSIC_DISC_MELLOHI,
    MUSIC_DISC_PIGSTEP,
    MUSIC_DISC_STAL,
    MUSIC_DISC_STRAD,
    MUSIC_DISC_WAIT,
    MUSIC_DISC_WARD,
    NAME_TAG,
    NETHERITE_AXE,
    NETHERITE_BOOTS,
    NETHERITE_CHESTPLATE,
    NETHERITE_HELMET,
    NETHERITE_HOE,
    NETHERITE_LEGGINGS,
    NETHERITE_PICKAXE,
    NETHERITE_SHOVEL,
    NETHERITE_SWORD,
    ORANGE_DYE,
    PINK_DYE,
    POISONOUS_POTATO,
    POTION,
    PUFFERFISH,
    PUMPKIN_PIE,
    PURPLE_DYE,
    RABBIT_STEW,
    RAW_BEEF(NamespacedKey(value = "beef")),
    RAW_CHICKEN(NamespacedKey(value = "chicken")),
    RAW_COD(NamespacedKey(value = "cod")),
    RAW_MUTTON(NamespacedKey(value = "mutton")),
    RAW_PORKCHOP(NamespacedKey(value = "porkchop")),
    RAW_RABBIT(NamespacedKey(value = "rabbit")),
    RAW_SALMON(NamespacedKey(value = "salmon")),
    RED_DYE,
    ROTTEN_FLESH,
    SADDLE,
    SHEARS,
    SHIELD,
    SPECTRAL_ARROW,
    SPIDER_EYE,
    STEAK(NamespacedKey(value = "cooked_beef")),
    STONE_AXE,
    STONE_HOE,
    STONE_PICKAXE,
    STONE_SHOVEL,
    STONE_SWORD,
    SUGAR,
    SUSPICIOUS_STEW,
    TIPPED_ARROW,
    TOTEM_OF_UNDYING,
    TROPICAL_FISH,
    TURTLE_SHELL(NamespacedKey(value = "turtle_helmet")),
    WHEAT,
    WHITE_DYE,
    WOODEN_AXE,
    WOODEN_HOE,
    WOODEN_PICKAXE,
    WOODEN_SHOVEL,
    WOODEN_SWORD,
    WRITTEN_BOOK,
    YELLOW_DYE,

    /**
     * Items with indirect use in the world
     */
    BANNER_PATTERN_CREEPER_CHARGE(NamespacedKey(value = "creeper_banner_pattern")),
    BANNER_PATTERN_FLOWER_CHARGE(NamespacedKey(value = "flower_banner_pattern")),
    BANNER_PATTERN_GLOBE(NamespacedKey(value = "globe_banner_pattern")),
    BANNER_PATTERN_SKULL_CHARGE(NamespacedKey(value = "skull_banner_pattern")),
    BANNER_PATTERN_SNOUT(NamespacedKey(value = "piglin_banner_pattern")),
    BANNER_PATTERN_THING(NamespacedKey(value = "mojang_banner_pattern")),
    BLAZE_POWDER,
    BLAZE_ROD,
    BOOK,
    BRICK,
    CHARCOAL,
    CLAY_BALL,
    CLOCK,
    COAL,
    DIAMOND,
    DRAGON_BREATH,
    EMERALD,
    ENCHANTED_BOOK,
    FEATHER,
    FERMENTED_SPIDER_EYE,
    FIREWORK_STAR,
    FLINT,
    GHAST_TEAR,
    GLISTERING_MELON_SLICE,
    GLOWSTONE_DUST,
    GOLD_NUGGET,
    GUNPOWDER,
    HEART_OF_THE_SEA,
    HONEYCOMB,
    INK_SAC,
    IRON_INGOT,
    IRON_NUGGET,
    LAPIS_LAZULI,
    LEATHER,
    MAGMA_CREAM,
    NAUTILUS_SHELL,
    NETHER_BRICK,
    NETHER_QUARTZ(NamespacedKey(value = "quartz")),
    NETHER_STAR,
    NETHERITE_INGOT,
    NETHERITE_SCRAP,
    PAPER,
    PHANTOM_MEMBRANE,
    POPPED_CHORUS_FRUIT,
    PRISMARINE_CRYSTALS,
    PRISMARINE_SHARD,
    RABBIT_HIDE,
    RABBIT_FOOT,
    SCUTE,
    SHULKER_SHELL,
    SLIMEBALL(NamespacedKey(value = "slime_ball")),
    STICK,

    /**
     * Spawn eggs
     */
    BAT_SPAWN_EGG,
    BEE_SPAWN_EGG,
    BLAZE_SPAWN_EGG,
    CAVE_SPIDER_SPAWN_EGG,
    CAT_SPAWN_EGG,
    CHICKEN_SPAWN_EGG,
    COD_SPAWN_EGG,
    COW_SPAWN_EGG,
    CREEPER_SPAWN_EGG,
    DOLPHIN_SPAWN_EGG,
    DONKEY_SPAWN_EGG,
    DROWNED_SPAWN_EGG,
    ELDER_GUARDIAN_SPAWN_EGG,
    ENDERMAN_SPAWN_EGG,
    ENDERMITE_SPAWN_EGG,
    EVOKER_SPAWN_EGG,
    FOX_SPAWN_EGG,
    GHAST_SPAWN_EGG,
    GUARDIAN_SPAWN_EGG,
    HOGLIN_SPAWN_EGG,
    HORSE_SPAWN_EGG,
    HUSK_SPAWN_EGG,
    LLAMA_SPAWN_EGG,
    MAGMA_CUBE_SPAWN_EGG,
    MOOSHROOM_SPAWN_EGG,
    MULE_SPAWN_EGG,
    OCELOT_SPAWN_EGG,
    PANDA_SPAWN_EGG,
    PARROT_SPAWN_EGG,
    PHANTOM_SPAWN_EGG,
    PIG_SPAWN_EGG,
    PIGLIN_SPAWN_EGG,
    PIGLIN_BRUTE_SPAWN_EGG,
    PILLAGER_SPAWN_EGG,
    POLAR_BEAR_SPAWN_EGG,
    PUFFERFISH_SPAWN_EGG,
    RABBIT_SPAWN_EGG,
    RAVAGER_SPAWN_EGG,
    SALMON_SPAWN_EGG,
    SHEEP_SPAWN_EGG,
    SHULKER_SPAWN_EGG,
    SILVERFISH_SPAWN_EGG,
    SKELETON_HORSE_SPAWN_EGG,
    SKELETON_SPAWN_EGG,
    SLIME_SPAWN_EGG,
    SPIDER_SPAWN_EGG,
    SQUID_SPAWN_EGG,
    STRAY_SPAWN_EGG,
    STRIDER_SPAWN_EGG,
    TRADER_LLAMA_SPAWN_EGG,
    TROPICAL_FISH_SPAWN_EGG,
    TURTLE_SPAWN_EGG,
    VEX_SPAWN_EGG,
    VILLAGER_SPAWN_EGG,
    VINDICATOR_SPAWN_EGG,
    WANDERING_TRADER_SPAWN_EGG,
    WITCH_SPAWN_EGG,
    WITHER_SKELETON_SPAWN_EGG,
    WOLF_SPAWN_EGG,
    ZOMBIE_SPAWN_EGG,
    ZOMBIE_HORSE_SPAWN_EGG,
    ZOMBIE_VILLAGER_SPAWN_EGG,
    ZOMBIFIED_PIGLIN_SPAWN_EGG,

    /**
     * Blocks (every block in the game can be represented as an item in an inventory)
     */
    ACACIA_BUTTON,
    ACACIA_DOOR,
    ACACIA_FENCE,
    ACACIA_FENCE_GATE,
    ACACIA_LEAVES,
    ACACIA_LOG,
    ACACIA_PLANKS,
    ACACIA_PRESSURE_PLATE,
    ACACIA_SAPLING,
    ACACIA_SIGN,
    ACACIA_SLAB,
    ACACIA_STAIRS,
    ACACIA_TRAPDOOR,
    ACACIA_WOOD,
    ACTIVATOR_RAIL,
    ALLIUM,
    ANCIENT_DEBRIS,
    ANDESITE,
    ANDESITE_SLAB,
    ANDESITE_STAIRS,
    ANDESITE_WALL,
    ANVIL,
    AZURE_BLUET,
    BAMBOO,
    BAMBOO_SHOOT,
    BEETROOTS,
    BARREL,
    BARRIER,
    BASALT,
    BEACON,
    BEDROCK,
    BEEHIVE,
    BEE_NEST,
    BELL,
    BIRCH_BUTTON,
    BIRCH_DOOR,
    BIRCH_FENCE,
    BIRCH_FENCE_GATE,
    BIRCH_LEAVES,
    BIRCH_LOG,
    BIRCH_PLANKS,
    BIRCH_PRESSURE_PLATE,
    BIRCH_SAPLING,
    BIRCH_SIGN,
    BIRCH_STAIRS,
    BIRCH_TRAPDOOR,
    BIRCH_WOOD,
    BLACK_BANNER,
    BLACK_BED,
    BLACK_CARPET,
    BLACK_CONCRETE,
    BLACK_CONCRETE_POWDER,
    BLACK_GLAZED_TERRACOTTA,
    BLACK_SHULKER_BOX,
    BLACK_STAINED_GLASS,
    BLACK_STAINED_GLASS_PANE,
    BLACK_TERRACOTTA,
    BLACK_WOOL,
    BLACKSTONE,
    BLACKSTONE_SLAB,
    BLACKSTONE_STAIRS,
    BLACKSTONE_WALL,
    BLAST_FURNACE,
    BLOCK_OF_COAL,
    BLOCK_OF_DIAMOND,
    BLOCK_OF_EMERALD,
    BLOCK_OF_GOLD,
    BLOCK_OF_IRON,
    BLOCK_OF_NETHERITE,
    BLOCK_OF_QUARTZ,
    BLOCK_OF_REDSTONE,
    BLUE_BANNER,
    BLUE_BED,
    BLUE_CARPET,
    BLUE_CONCRETE,
    BLUE_CONCRETE_POWDER,
    BLUE_GLAZED_TERRACOTTA,
    BLUE_ICE,
    BLUE_ORCHID,
    BLUE_SHULKER_BOX,
    BLUE_STAINED_GLASS,
    BLUE_STAINED_GLASS_PANE,
    BLUE_TERRACOTTA,
    BLUE_WOOL,
    BONE_BLOCK,
    BOOKSHELF,
    BRAIN_CORAL,
    BRAIN_CORAL_BLOCK,
    BRAIN_CORAL_FAN,
    BREWING_STAND,
    BRICK_SLAB,
    BRICK_STAIRS,
    BRICK_WALL,
    BRICKS,
    BROWN_BANNER,
    BROWN_BED,
    BROWN_CARPET,
    BROWN_CONCRETE,
    BROWN_CONCRETE_POWDER,
    BROWN_GLAZED_TERRACOTTA,
    BROWN_MUSHROOM,
    BROWN_MUSHROOM_BLOCK,
    BROWN_SHULKER_BOX,
    BROWN_STAINED_GLASS,
    BROWN_STAINED_GLASS_PANE,
    BROWN_TERRACOTTA,
    BROWN_WOOL,
    BUBBLE_CORAL,
    BUBBLE_CORAL_BLOCK,
    BUBBLE_CORAL_FAN,
    CACTUS,
    CAKE,
    CAMPFIRE,
    CARROTS,
    CARTOGRAPHY_TABLE,
    CARVED_PUMPKIN,
    CAULDRON,
    CHAIN,
    CHAIN_COMMAND_BLOCK,
    CHEST,
    CHIPPED_ANVIL,
    CHISELED_NETHER_BRICKS,
    CHISELED_POLISHED_BLACKSTONE,
    CHISELED_QUARTZ_BLOCK,
    CHISELED_RED_SANDSTONE,
    CHISELED_SANDSTONE,
    CHISELED_STONE_BRICKS,
    CHORUS_FLOWER,
    CHORUS_PLANT,
    CLAY,
    COAL_ORE,
    COARSE_DIRT,
    COBBLESTONE,
    COBBLESTONE_SLAB,
    COBBLESTONE_STAIRS,
    COBBLESTONE_WALL,
    COBWEB,
    COCOA,
    COMMAND_BLOCK,
    COMPOSTER,
    CONDUIT,
    CORNFLOWER,
    CRACKED_NETHER_BRICKS,
    CRACKED_POLISHED_BLACKSTONE_BRICKS,
    CRACKED_STONE_BRICKS,
    CRAFTING_TABLE,
    CREEPER_HEAD,
    CRIMSON_BUTTON,
    CRIMSON_DOOR,
    CRIMSON_FENCE,
    CRIMSON_FENCE_GATE,
    CRIMSON_FUNGUS,
    CRIMSON_HYPHAE,
    CRIMSON_NYLIUM,
    CRIMSON_PLANKS,
    CRIMSON_PRESSURE_PLATE,
    CRIMSON_ROOTS,
    CRIMSON_SIGN,
    CRIMSON_SLAB,
    CRIMSON_STAIRS,
    CRIMSON_STEM,
    CRIMSON_TRAPDOOR,
    CRYING_OBSIDIAN,
    CUT_RED_SANDSTONE,
    CUT_RED_SANDSTONE_SLAB,
    CUT_SANDSTONE,
    CUT_SANDSTONE_SLAB,
    CYAN_BANNER,
    CYAN_BED,
    CYAN_CARPET,
    CYAN_CONCRETE,
    CYAN_CONCRETE_POWDER,
    CYAN_GLAZED_TERRACOTTA,
    CYAN_SHULKER_BOX,
    CYAN_STAINED_GLASS,
    CYAN_STAINED_GLASS_PANE,
    CYAN_TERRACOTTA,
    CYAN_WOOL,
    DAMAGED_ANVIL,
    DANDELION,
    DARK_OAK_BUTTON,
    DARK_OAK_DOOR,
    DARK_OAK_FENCE,
    DARK_OAK_FENCE_GATE,
    DARK_OAK_LEAVES,
    DARK_OAK_LOG,
    DARK_OAK_PLANKS,
    DARK_OAK_PRESSURE_PLATE,
    DARK_OAK_SAPLING,
    DARK_OAK_SIGN,
    DARK_OAK_STAIRS,
    DARK_OAK_TRAPDOOR,
    DARK_OAK_WOOD,
    DARK_PRISMARINE,
    DARK_PRISMARINE_SLAB,
    DARK_PRISMARINE_STAIRS,
    DAYLIGHT_DETECTOR,
    DEAD_BRAIN_CORAL,
    DEAD_BRAIN_CORAL_BLOCK,
    DEAD_BRAIN_CORAL_FAN,
    DEAD_BUBBLE_CORAL,
    DEAD_BUBBLE_CORAL_BLOCK,
    DEAD_BUBBLE_CORAL_FAN,
    DEAD_BUSH,
    DEAD_FIRE_CORAL,
    DEAD_FIRE_CORAL_BLOCK,
    DEAD_FIRE_CORAL_FAN,
    DEAD_HORN_CORAL,
    DEAD_HORN_CORAL_BLOCK,
    DEAD_HORN_CORAL_FAN,
    DEAD_TUBE_CORAL,
    DEAD_TUBE_CORAL_BLOCK,
    DEAD_TUBE_CORAL_FAN,
    DETECTOR_RAIL,
    DIAMOND_ORE,
    DIORITE,
    DIORITE_SLAB,
    DIORITE_STAIRS,
    DIORITE_WALL,
    DIRT,
    DISPENSER,
    DRAGON_EGG,
    DRAGON_HEAD,
    DRIED_KELP_BLOCK,
    DROPPER,
    EMERALD_ORE,
    ENCHANTING_TABLE,
    END_PORTAL_FRAME,
    END_ROD,
    END_STONE,
    END_STONE_BRICK_SLAB,
    END_STONE_BRICK_STAIRS,
    END_STONE_BRICK_WALL,
    END_STONE_BRICKS,
    ENDER_CHEST,
    FARMLAND,
    FERN,
    FIRE,
    FIRE_CORAL,
    FIRE_CORAL_BLOCK,
    FIRE_CORAL_FAN,
    FLETCHING_TABLE,
    FLOWER_POT,
    FURNACE,
    GILDED_BLACKSTONE,
    GLASS,
    GLASS_PANE,
    GLOWSTONE,
    GOLD_ORE,
    GRANITE,
    GRANITE_SLAB,
    GRANITE_STAIRS,
    GRANITE_WALL,
    GRASS,
    GRASS_BLOCK,
    GRASS_PATH,
    GRAVEL,
    GRAY_BANNER,
    GRAY_BED,
    GRAY_CARPET,
    GRAY_CONCRETE,
    GRAY_CONCRETE_POWDER,
    GRAY_GLAZED_TERRACOTTA,
    GRAY_SHULKER_BOX,
    GRAY_STAINED_GLASS,
    GRAY_STAINED_GLASS_PANE,
    GRAY_TERRACOTTA,
    GRAY_WOOL,
    GREEN_BANNER,
    GREEN_BED,
    GREEN_CARPET,
    GREEN_CONCRETE,
    GREEN_CONCRETE_POWDER,
    GREEN_GLAZED_TERRACOTTA,
    GREEN_SHULKER_BOX,
    GREEN_STAINED_GLASS,
    GREEN_STAINED_GLASS_PANE,
    GREEN_TERRACOTTA,
    GREEN_WOOL,
    GRINDSTONE,
    HAY_BALE,
    HEAVY_WEIGHTED_PRESSURE_PLATE,
    HONEY_BLOCK,
    HONEYCOMB_BLOCK,
    HOPPER,
    HORN_CORAL,
    HORN_CORAL_BLOCK,
    HORN_CORAL_FAN,
    ICE,
    INFESTED_CHISELED_STONE_BRICKS,
    INFESTED_COBBLESTONE,
    INFESTED_CRACKED_STONE_BRICKS,
    INFESTED_MOSSY_STONE_BRICKS,
    INFESTED_STONE,
    INFESTED_STONE_BRICKS,
    IRON_BARS,
    IRON_DOOR,
    IRON_ORE,
    IRON_TRAPDOOR,
    JACK_O_LANTERN,
    JIGSAW_BLOCK,
    JUKEBOX,
    JUNGLE_BUTTON,
    JUNGLE_DOOR,
    JUNGLE_FENCE,
    JUNGLE_FENCE_GATE,
    JUNGLE_LEAVES,
    JUNGLE_LOG,
    JUNGLE_PLANKS,
    JUNGLE_PRESSURE_PLATE,
    JUNGLE_SAPLING,
    JUNGLE_SIGN,
    JUNGLE_SLAB,
    JUNGLE_STAIRS,
    JUNGLE_TRAPDOOR,
    JUNGLE_WOOD,
    LADDER,
    LANTERN,
    LAPIS_LAZULI_BLOCK,
    LAPIS_LAZULI_ORE,
    LARGE_FERN,
    LAVA,
    LECTERN,
    LEVER,
    LIGHT_BLUE_BANNER,
    LIGHT_BLUE_BED,
    LIGHT_BLUE_CARPET,
    LIGHT_BLUE_CONCRETE,
    LIGHT_BLUE_CONCRETE_POWDER,
    LIGHT_BLUE_GLAZED_TERRACOTTA,
    LIGHT_BLUE_SHULKER_BOX,
    LIGHT_BLUE_STAINED_GLASS,
    LIGHT_BLUE_STAINED_GLASS_PANE,
    LIGHT_BLUE_TERRACOTTA,
    LIGHT_BLUE_WOOL,
    LIGHT_GRAY_BANNER,
    LIGHT_GRAY_BED,
    LIGHT_GRAY_CARPET,
    LIGHT_GRAY_CONCRETE,
    LIGHT_GRAY_CONCRETE_POWDER,
    LIGHT_GRAY_GLAZED_TERRACOTTA,
    LIGHT_GRAY_SHULKER_BOX,
    LIGHT_GRAY_STAINED_GLASS,
    LIGHT_GRAY_STAINED_GLASS_PANE,
    LIGHT_GRAY_TERRACOTTA,
    LIGHT_GRAY_WOOL,
    LIGHT_WEIGHTED_PRESSURE_PLATE,
    LILAC,
    LILY_OF_THE_VALLEY,
    LILY_PAD,
    LIME_BANNER,
    LIME_BED,
    LIME_CARPET,
    LIME_CONCRETE,
    LIME_CONCRETE_POWDER,
    LIME_GLAZED_TERRACOTTA,
    LIME_SHULKER_BOX,
    LIME_STAINED_GLASS,
    LIME_STAINED_GLASS_PANE,
    LIME_TERRACOTTA,
    LIME_WOOL,
    LODESTONE,
    LOOM,
    MAGENTA_BANNER,
    MAGENTA_BED,
    MAGENTA_CARPET,
    MAGENTA_CONCRETE,
    MAGENTA_CONCRETE_POWDER,
    MAGENTA_GLAZED_TERRACOTTA,
    MAGENTA_SHULKER_BOX,
    MAGENTA_STAINED_GLASS,
    MAGENTA_STAINED_GLASS_PANE,
    MAGENTA_TERRACOTTA,
    MAGENTA_WOOL,
    MAGMA_BLOCK,
    MELON,
    MELON_STEM,
    MOSSY_COBBLESTONE,
    MOSSY_COBBLESTONE_SLAB,
    MOSSY_COBBLESTONE_STAIRS,
    MOSSY_COBBLESTONE_WALL,
    MOSSY_STONE_BRICK_SLAB,
    MOSSY_STONE_BRICK_STAIRS,
    MOSSY_STONE_BRICK_WALL,
    MOSSY_STONE_BRICKS,
    MUSHROOM_STEM,
    MYCELIUM,
    NETHER_BRICK_FENCE,
    NETHER_BRICK_SLAB,
    NETHER_BRICK_STAIRS,
    NETHER_BRICK_WALL,
    NETHER_BRICKS,
    NETHER_GOLD_ORE,
    NETHER_QUARTZ_ORE,
    NETHER_SPROUTS,
    NETHER_WART_BLOCK,
    NETHERRACK,
    NOTE_BLOCK,
    OAK_BUTTON,
    OAK_DOOR,
    OAK_FENCE,
    OAK_FENCE_GATE,
    OAK_LEAVES,
    OAK_LOG,
    OAK_PLANKS,
    OAK_PRESSURE_PLATE,
    OAK_SAPLING,
    OAK_SIGN,
    OAK_SLAB,
    OAK_STAIRS,
    OAK_TRAPDOOR,
    OAK_WOOD,
    OBSERVER,
    OBSIDIAN,
    OMINOUS_BANNER,
    ORANGE_BANNER,
    ORANGE_BED,
    ORANGE_CARPET,
    ORANGE_CONCRETE,
    ORANGE_CONCRETE_POWDER,
    ORANGE_GLAZED_TERRACOTTA,
    ORANGE_SHULKER_BOX,
    ORANGE_STAINED_GLASS,
    ORANGE_STAINED_GLASS_PANE,
    ORANGE_TERRACOTTA,
    ORANGE_TULIP,
    ORANGE_WOOL,
    OXEYE_DAISY,
    PACKED_ICE,
    PEONY,
    PETRIFIED_OAK_SLAB,
    PINK_BANNER,
    PINK_BED,
    PINK_CARPET,
    PINK_CONCRETE,
    PINK_CONCRETE_POWDER,
    PINK_GLAZED_TERRACOTTA,
    PINK_SHULKER_BOX,
    PINK_STAINED_GLASS,
    PINK_STAINED_GLASS_PANE,
    PINK_TERRACOTTA,
    PINK_TULIP,
    PINK_WOOL,
    PISTON,
    PLAYER_HEAD,
    PODZOL,
    POINTED,
    POLISHED_ANDESITE,
    POLISHED_ANDESITE_SLAB,
    POLISHED_ANDESITE_STAIRS,
    POLISHED_BASALT,
    POLISHED_BLACKSTONE,
    POLISHED_BLACKSTONE_BRICK_SLAB,
    POLISHED_BLACKSTONE_BRICK_STAIRS,
    POLISHED_BLACKSTONE_BRICK_WALL,
    POLISHED_BLACKSTONE_BRICKS,
    POLISHED_BLACKSTONE_BUTTON,
    POLISHED_BLACKSTONE_PRESSURE_PLATE,
    POLISHED_BLACKSTONE_SLAB,
    POLISHED_BLACKSTONE_STAIRS,
    POLISHED_BLACKSTONE_WALL,
    POLISHED_DIORITE,
    POLISHED_DIORITE_SLAB,
    POLISHED_DIORITE_STAIRS,
    POLISHED_GRANITE,
    POLISHED_GRANITE_SLAB,
    POLISHED_GRANITE_STAIRS,
    POPPY,
    POTATOES,
    POWERED_RAIL,
    PRISMARINE,
    PRISMARINE_BRICK_SLAB,
    PRISMARINE_BRICK_STAIRS,
    PRISMARINE_BRICKS,
    PRISMARINE_SLAB,
    PRISMARINE_STAIRS,
    PRISMARINE_WALL,
    PUMPKIN,
    PUMPKIN_STEM,
    PURPLE_BANNER,
    PURPLE_BED,
    PURPLE_CARPET,
    PURPLE_CONCRETE,
    PURPLE_CONCRETE_POWDER,
    PURPLE_GLAZED_TERRACOTTA,
    PURPLE_SHULKER_BOX,
    PURPLE_STAINED_GLASS,
    PURPLE_STAINED_GLASS_PANE,
    PURPLE_TERRACOTTA,
    PURPLE_WOOL,
    PURPUR_BLOCK,
    PURPUR_PILLAR,
    PURPUR_SLAB,
    PURPUR_STAIRS,
    QUARTZ_BRICKS,
    QUARTZ_PILLAR,
    QUARTZ_SLAB,
    QUARTZ_STAIRS,
    RAIL,
    RED_BANNER,
    RED_BED,
    RED_CARPET,
    RED_CONCRETE,
    RED_CONCRETE_POWDER,
    RED_GLAZED_TERRACOTTA,
    RED_MUSHROOM,
    RED_MUSHROOM_BLOCK,
    RED_NETHER_BRICK_SLAB,
    RED_NETHER_BRICK_STAIRS,
    RED_NETHER_BRICK_WALL,
    RED_NETHER_BRICKS,
    RED_SAND,
    RED_SANDSTONE,
    RED_SANDSTONE_SLAB,
    RED_SANDSTONE_STAIRS,
    RED_SANDSTONE_WALL,
    RED_SHULKER_BOX,
    RED_STAINED_GLASS,
    RED_STAINED_GLASS_PANE,
    RED_TERRACOTTA,
    RED_TULIP,
    RED_WOOL,
    REDSTONE_COMPARATOR,
    REDSTONE_LAMP,
    REDSTONE_ORE,
    REDSTONE_REPEATER,
    REDSTONE_TORCH,
    REPEATING_COMMAND_BLOCK,
    RESPAWN_ANCHOR,
    ROSE_BUSH,
    SAND,
    SANDSTONE,
    SANDSTONE_SLAB,
    SANDSTONE_STAIRS,
    SANDSTONE_WALL,
    SCAFFOLDING,
    SEA_LANTERN,
    SEA_PICKLE,
    SEAGRASS,
    SHROOMLIGHT,
    SHULKER_BOX,
    SKELETON_SKULL,
    SLIME_BLOCK,
    SMITHING_TABLE,
    SMOKER,
    SMOOTH_QUARTZ_BLOCK,
    SMOOTH_QUARTZ_SLAB,
    SMOOTH_QUARTZ_STAIRS,
    SMOOTH_RED_SANDSTONE,
    SMOOTH_RED_SANDSTONE_SLAB,
    SMOOTH_RED_SANDSTONE_STAIRS,
    SMOOTH_SANDSTONE,
    SMOOTH_SANDSTONE_SLAB,
    SMOOTH_SANDSTONE_STAIRS,
    SMOOTH_STONE,
    SMOOTH_STONE_SLAB,
    SNOW,
    SNOW_BLOCK,
    SOUL_CAMPFIRE,
    SOUL_FIRE,
    SOUL_LANTERN,
    SOUL_SAND,
    SOUL_SOIL,
    SOUL_TORCH,
    SPAWNER,
    SPONGE,
    SPRUCE_BUTTON,
    SPRUCE_DOOR,
    SPRUCE_FENCE,
    SPRUCE_FENCE_GATE,
    SPRUCE_LEAVES,
    SPRUCE_LOG,
    SPRUCE_PLANKS,
    SPRUCE_PRESSURE_PLATE,
    SPRUCE_SAPLING,
    SPRUCE_SIGN,
    SPRUCE_SLAB,
    SPRUCE_STAIRS,
    SPRUCE_TRAPDOOR,
    SPRUCE_WOOD,
    STICKY_PISTON,
    STONE,
    STONE_BRICK_SLAB,
    STONE_BRICK_STAIRS,
    STONE_BRICK_WALL,
    STONE_BRICKS,
    STONE_BUTTON,
    STONE_PRESSURE_PLATE,
    STONE_SLAB,
    STONE_STAIRS,
    STONECUTTER,
    STRIPPED_ACACIA_LOG,
    STRIPPED_ACACIA_WOOD,
    STRIPPED_BIRCH_LOG,
    STRIPPED_BIRCH_WOOD,
    STRIPPED_CRIMSON_HYPHAE,
    STRIPPED_CRIMSON_STEM,
    STRIPPED_DARK_OAK_LOG,
    STRIPPED_DARK_OAK_WOOD,
    STRIPPED_JUNGLE_LOG,
    STRIPPED_JUNGLE_WOOD,
    STRIPPED_OAK_LOG,
    STRIPPED_OAK_WOOD,
    STRIPPED_SPRUCE_LOG,
    STRIPPED_SPRUCE_WOOD,
    STRIPPED_WARPED_HYPHAE,
    STRIPPED_WARPED_STEM,
    STRUCTURE_BLOCK,
    STRUCTURE_VOID,
    SUGAR_CANE,
    SUNFLOWER,
    SWEET_BERRY_BUSH,
    TALL_GRASS,
    TALL_SEAGRASS,
    TARGET,
    TERRACOTTA,
    TNT,
    TORCH,
    TRAPPED_CHEST,
    TRIPWIRE,
    TRIPWIRE_HOOK,
    TUBE_CORAL,
    TUBE_CORAL_BLOCK,
    TUBE_CORAL_FAN,
    TURTLE_EGG,
    TWISTING_VINES,
    VINES,
    WARPED_BUTTON,
    WARPED_DOOR,
    WARPED_FENCE,
    WARPED_FENCE_GATE,
    WARPED_FUNGUS,
    WARPED_HYPHAE,
    WARPED_NYLIUM,
    WARPED_PLANKS,
    WARPED_PRESSURE_PLATE,
    WARPED_ROOTS,
    WARPED_SIGN,
    WARPED_SLAB,
    WARPED_STAIRS,
    WARPED_STEM,
    WARPED_TRAPDOOR,
    WARPED_WART_BLOCK,
    WATER,
    WEEPING_VINES,
    WET_SPONGE,
    WHEAT_CROPS,
    WHITE_BANNER,
    WHITE_BED,
    WHITE_CARPET,
    WHITE_CONCRETE,
    WHITE_CONCRETE_POWDER,
    WHITE_GLAZED_TERRACOTTA,
    WHITE_SHULKER_BOX,
    WHITE_STAINED_GLASS,
    WHITE_STAINED_GLASS_PANE,
    WHITE_TERRACOTTA,
    WHITE_TULIP,
    WHITE_WOOL,
    WITHER_ROSE,
    WITHER_SKELETON_SKULL,
    YELLOW_BANNER,
    YELLOW_BED,
    YELLOW_CARPET,
    YELLOW_CONCRETE,
    YELLOW_CONCRETE_POWDER,
    YELLOW_GLAZED_TERRACOTTA,
    YELLOW_SHULKER_BOX,
    YELLOW_STAINED_GLASS,
    YELLOW_STAINED_GLASS_PANE,
    YELLOW_TERRACOTTA,
    YELLOW_WOOL,
    ZOMBIE_HEAD,

    /**
     * Miscellaneous
     */
    AIR;

    override val key = internalKey ?: NamespacedKey(value = name.toLowerCase())

    companion object {

        val KEYS = Index.create(Material::class.java) { it.key }
    }
}