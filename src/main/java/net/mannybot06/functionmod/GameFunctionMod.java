package net.mannybot06.functionmod;

import com.mojang.blaze3d.shaders.FogShape;
import com.mojang.logging.LogUtils;
import net.mannybot06.functionmod.effect.ModEffects;
import net.mannybot06.functionmod.sound.ModSounds;
import net.minecraft.client.renderer.FogRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.material.FogType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.ForgeHooksClient;
import net.minecraftforge.client.event.ViewportEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(GameFunctionMod.MOD_ID)
public class GameFunctionMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "functionmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public GameFunctionMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // REGISTER MOD SOUNDS
        ModSounds.register(modEventBus);

        //REGISTER MOD EFFECTS
        ModEffects.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event){

    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = GameFunctionMod.MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onFogRender(ViewportEvent.RenderFog event) {
            Entity camEntity = event.getCamera().getEntity();
            if (camEntity instanceof LivingEntity livingEntity) {
                var effectInstance = livingEntity.getEffect(ModEffects.NEARSIGHTED.get());
                if (effectInstance != null) {
                    int amplifier = effectInstance.getAmplifier();
                    float factor = 1.5F / (amplifier + 1);
                    float start = 1.0F;
                    float end = 8.0F * factor;

                    event.setNearPlaneDistance(start);
                    event.setFarPlaneDistance(end);
                    event.setCanceled(true);
                }
            }
        }

        @SubscribeEvent
        public static void onFogColor(ViewportEvent.ComputeFogColor event) {
            Entity camEntity = event.getCamera().getEntity();
            if (camEntity instanceof LivingEntity livingEntity) {
                if (livingEntity.hasEffect(ModEffects.NEARSIGHTED.get())) {
                    event.setRed(0f);
                    event.setGreen(0f);
                    event.setBlue(0f);
                }
            }
        }


    }
}
