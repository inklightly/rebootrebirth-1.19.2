package com.rebootrebirth.mod;

import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("rebootrebirth")
public class RebootRebirthMod {

    public static final String MOD_ID = "rebootrebirth";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

    public RebootRebirthMod() {
        LOGGER.info("Reboot Rebirth!");
    }
}
