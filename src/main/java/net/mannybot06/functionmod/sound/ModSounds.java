package net.mannybot06.functionmod.sound;

import net.mannybot06.functionmod.GameFunctionMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, GameFunctionMod.MOD_ID);

    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
    //GAME FUNCTION SOUNDS
    public static final RegistryObject<SoundEvent> ZONE_FLIP_BAD = registerSoundEvents("zone_flip_bad");
    public static final RegistryObject<SoundEvent> ZONE_FLIP_GOOD = registerSoundEvents("zone_flip_good");

    //INDIVIDUAL ORIGIN SFX:

    //SNIFFER
    public static final RegistryObject<SoundEvent> WAYLAY_SLOW = registerSoundEvents("waylay_slow");
    public static final RegistryObject<SoundEvent> WAYLAY_REFRACT = registerSoundEvents("waylay_refract");
    public static final RegistryObject<SoundEvent> WAYLAY_ULT = registerSoundEvents("waylay_ult");
    public static final RegistryObject<SoundEvent> HOLY_CAST = registerSoundEvents("holy_cast");
    public static final RegistryObject<SoundEvent> WITCH_TIME = registerSoundEvents("witch_time");

    //SKYDANCER
    public static final RegistryObject<SoundEvent> JETT_DASH = registerSoundEvents("jett_dash");
    public static final RegistryObject<SoundEvent> JETT_UPDRAFT = registerSoundEvents("jett_updraft");
    public static final RegistryObject<SoundEvent> CLOUDBURST_THROW = registerSoundEvents("cloudburst_throw");

    //PYROMANCER
    public static final RegistryObject<SoundEvent> KNIGHT_FIREBALL = registerSoundEvents("knight_fireball");
    public static final RegistryObject<SoundEvent> RUDE_BUSTER_HIT = registerSoundEvents("rude_buster_hit");

    //ENDERMAN
    public static final RegistryObject<SoundEvent> KILLBANNER_BASE_1 = registerSoundEvents("killbanner_base_1");
    public static final RegistryObject<SoundEvent> KILLBANNER_BASE_2 = registerSoundEvents("killbanner_base_2");
    public static final RegistryObject<SoundEvent> KILLBANNER_BASE_3 = registerSoundEvents("killbanner_base_3");
    public static final RegistryObject<SoundEvent> KILLBANNER_BASE_4 = registerSoundEvents("killbanner_base_4");
    public static final RegistryObject<SoundEvent> KILLBANNER_BASE_ACE = registerSoundEvents("killbanner_base_ace");

    //MUSIC
    public static final RegistryObject<SoundEvent> DOUBLE_TIME = registerSoundEvents("double_time");
    public static final RegistryObject<SoundEvent> IN_THE_FLOW = registerSoundEvents("in_the_flow");

    //MISC OR UNUSED
    public static final RegistryObject<SoundEvent> TRISTRIKE_THROW = registerSoundEvents("tristrike_throw");
    public static final RegistryObject<SoundEvent> DELTARUNE_FALL = registerSoundEvents("deltarune_fall");

    private static RegistryObject<SoundEvent> registerSoundEvents(String name) {
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(GameFunctionMod.MOD_ID, name)));
    }


}
