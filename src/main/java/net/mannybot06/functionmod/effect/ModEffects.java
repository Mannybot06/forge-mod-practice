package net.mannybot06.functionmod.effect;

import net.mannybot06.functionmod.GameFunctionMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
    public static final DeferredRegister<MobEffect> MOB_EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, GameFunctionMod.MOD_ID);

    public static final RegistryObject<MobEffect> SUPPRESSED = MOB_EFFECTS.register("suppressed",
            () -> new SuppressedEffect(MobEffectCategory.HARMFUL, 11549771));

    public static final RegistryObject<MobEffect> DAZED = MOB_EFFECTS.register("dazed",
            () -> new DazedEffect(MobEffectCategory.HARMFUL, 16562214));

    public static final RegistryObject<MobEffect> NEARSIGHTED = MOB_EFFECTS.register("nearsighted",
            () -> new NearsightedEffect(MobEffectCategory.HARMFUL, 16978214));

    public static final RegistryObject<MobEffect> REDTEAM = MOB_EFFECTS.register("redteam",
            () -> new NearsightedEffect(MobEffectCategory.NEUTRAL, 15414369));

    public static final RegistryObject<MobEffect> BLUETEAM = MOB_EFFECTS.register("blueteam",
            () -> new NearsightedEffect(MobEffectCategory.NEUTRAL, 3430635));

    public static void register(IEventBus eventBus){
        MOB_EFFECTS.register(eventBus);
    }
}