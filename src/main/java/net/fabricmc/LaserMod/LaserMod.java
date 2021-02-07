package net.fabricmc.LaserMod;

import net.fabricmc.LaserMod.blocks.Lens;
import net.fabricmc.LaserMod.blocks.Laser;
import net.fabricmc.LaserMod.blocks.LaserEntity;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LaserMod implements ModInitializer {
	public static final Block Lens = new Lens();
	public static final Block Laser = new Laser();

	public static BlockEntityType<LaserEntity> LaserEntityData;
	
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		System.out.println("Laser mod initialized, registering blocks");

		Registry.register(Registry.BLOCK, new Identifier("lasermod", "lens"), Lens);
		Registry.register(Registry.ITEM, new Identifier("lasermod", "lens"), new BlockItem(Lens, new FabricItemSettings().group(ItemGroup.REDSTONE)));
		BlockRenderLayerMap.INSTANCE.putBlock(Lens, RenderLayer.getCutout());

		Registry.register(Registry.BLOCK, new Identifier("lasermod", "laser"), Laser);
		Registry.register(Registry.ITEM, new Identifier("lasermod", "laser"), new BlockItem(Laser, new FabricItemSettings().group(ItemGroup.REDSTONE)));
		LaserEntityData = Registry.register(Registry.BLOCK_ENTITY_TYPE, "modid:demo", BlockEntityType.Builder.create(LaserEntity::new, Laser).build(null));
		BlockRenderLayerMap.INSTANCE.putBlock(Laser, RenderLayer.getCutout());
	}
}
