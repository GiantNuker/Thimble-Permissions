package io.github.indicode.fabric.permissions.mixin;

import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.datafixers.DataFixer;
import io.github.indicode.fabric.permissions.PermissionLoadHandler;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.WorldGenerationProgressListenerFactory;
import net.minecraft.server.command.CommandManager;
import net.minecraft.util.UserCache;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.File;
import java.net.Proxy;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    private void saveInstance(File file_1, Proxy proxy_1, DataFixer dataFixer_1, CommandManager commandManager_1, YggdrasilAuthenticationService yggdrasilAuthenticationService_1, MinecraftSessionService minecraftSessionService_1, GameProfileRepository gameProfileRepository_1, UserCache userCache_1, WorldGenerationProgressListenerFactory worldGenerationProgressListenerFactory_1, String string_1, CallbackInfo ci) {
        PermissionLoadHandler.server = (MinecraftServer)(Object) this;
    }
}
