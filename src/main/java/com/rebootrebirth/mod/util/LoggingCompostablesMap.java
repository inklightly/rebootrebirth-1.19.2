package com.rebootrebirth.mod.util;

import it.unimi.dsi.fastutil.objects.Object2FloatMap;
import it.unimi.dsi.fastutil.objects.Object2FloatOpenHashMap;
import net.minecraft.world.level.ItemLike;
import com.rebootrebirth.mod.util.PatchLogger;
import com.rebootrebirth.mod.util.PatchSupport;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class LoggingCompostablesMap extends Object2FloatOpenHashMap<ItemLike> {

    private static final Set<String> SEEN = ConcurrentHashMap.newKeySet();

    public LoggingCompostablesMap(Object2FloatMap<ItemLike> existing) {
        super(existing); // copies existing entries
    }

    @Override
    public float put(ItemLike key, float value) {
        synchronized (PatchSupport.lock("compostables.put")) {
            PatchLogger.logUseOnce("compostables.put");
            return super.put(key, value); // or delegate.put(key, value)
        }
    }

    @Override
    public void putAll(java.util.Map<? extends ItemLike, ? extends Float> m) {
        synchronized (PatchSupport.lock("compostables.putAll")) {
            PatchLogger.logUseOnce("compostables.putAll");
            super.putAll(m); // or delegate.putAll(m)
        }
    }
}
