package org.kryptonmc.krypton.world.block.loot;

interface BlockLootCondition {

}

class ConditionAlternative : BlockLootCondition {
    var terms: List<BlockLootCondition> = List<BlockLootCondition>()
}
