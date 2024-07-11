package dev.huli.zcrystals.fabric

import dev.huli.zcrystals.ZCrystals
import net.fabricmc.api.ModInitializer

class CobblemonFabric : ModInitializer {
    override fun onInitialize() {
        System.out.println("Fabric Mod init")
        ZCrystals.initialize()
    }
}
