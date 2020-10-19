package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;
import com.pmso.tugaflavours.client.blocks.BlockItemBase;
import com.pmso.tugaflavours.client.items.ItemBase;
import com.pmso.tugaflavours.client.items.ModMusicDiscItem;
import com.pmso.tugaflavours.util.enums.ModArmourMaterial;
import com.pmso.tugaflavours.util.enums.ModItemTier;

import net.minecraft.item.Rarity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

	public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
			Tugaflavours.MOD_ID);

	public static void init() {
		ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
	}

	// Items
	public static final RegistryObject<Item> TUGA_COD = ITEMS.register("tuga_cod", ItemBase::new);
	public static final RegistryObject<Item> DRIED_COD = ITEMS.register("dried_cod", ItemBase::new);
	public static final RegistryObject<Item> CORK = ITEMS.register("cork", ItemBase::new);

	// Tools
	public static final RegistryObject<SwordItem> CORK_SWORD = ITEMS.register("cork_sword",
			() -> new SwordItem(ModItemTier.CORK, 2, -2.4f, new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<AxeItem> CORK_AXE = ITEMS.register("cork_axe",
			() -> new AxeItem(ModItemTier.CORK, 3, -3.1f, new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<PickaxeItem> CORK_PICKAXE = ITEMS.register("cork_pickaxe",
			() -> new PickaxeItem(ModItemTier.CORK, 1, -2.8f, new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<HoeItem> CORK_HOE = ITEMS.register("cork_hoe",
			() -> new HoeItem(ModItemTier.CORK, 1, -2.8f, new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<ShovelItem> CORK_SHOVEL = ITEMS.register("cork_shovel",
			() -> new ShovelItem(ModItemTier.CORK, 1, -3.0f, new Item.Properties().group(Tugaflavours.TAB)));

	// Armours
	public static final RegistryObject<ArmorItem> CORK_HELMET = ITEMS.register("cork_helmet",
			() -> new ArmorItem(ModArmourMaterial.CORK, EquipmentSlotType.HEAD,
					new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<ArmorItem> CORK_CHESTPLATE = ITEMS.register("cork_chestplate",
			() -> new ArmorItem(ModArmourMaterial.CORK, EquipmentSlotType.CHEST,
					new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<ArmorItem> CORK_LEGGINGS = ITEMS.register("cork_leggings",
			() -> new ArmorItem(ModArmourMaterial.CORK, EquipmentSlotType.LEGS,
					new Item.Properties().group(Tugaflavours.TAB)));

	public static final RegistryObject<ArmorItem> CORK_BOOTS = ITEMS.register("cork_boots",
			() -> new ArmorItem(ModArmourMaterial.CORK, EquipmentSlotType.FEET,
					new Item.Properties().group(Tugaflavours.TAB)));

	// Block Items
	public static final RegistryObject<Item> CORK_BLOCK_ITEM = ITEMS.register("cork_block",
			() -> new BlockItemBase(ModBlocks.CORK_BLOCK.get()));
	
	public static final RegistryObject<Item> CORK_LOG_ITEM = ITEMS.register("cork_log", 
			()-> new BlockItemBase(ModBlocks.CORK_LOG.get()));

	public static final RegistryObject<Item> DISH_ITEM = ITEMS.register("dish_block",
			() -> new BlockItemBase(ModBlocks.DISH_BLOCK.get()));

	public static final RegistryObject<Item> FRANCESINHA_ITEM = ITEMS.register("francesinha_block",
			() -> new BlockItemBase(ModBlocks.FRANCESINHA_BLOCK.get()));

	// Record Item
	public static final RegistryObject<MusicDiscItem> HINO_DISC = ITEMS.register("hino_disc",
			() -> new MusicDiscItem(15, ModSounds.LAZY_HINO_MUSIC, new Item.Properties().group(Tugaflavours.TAB).maxStackSize(1).rarity(Rarity.RARE)));
}
