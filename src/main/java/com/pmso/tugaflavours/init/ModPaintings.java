package com.pmso.tugaflavours.init;

import com.pmso.tugaflavours.Tugaflavours;

import net.minecraft.entity.item.PaintingType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPaintings {
	public static final DeferredRegister<PaintingType> PAINTING_TYPES = DeferredRegister.create(ForgeRegistries.PAINTING_TYPES,
			Tugaflavours.MOD_ID);
	
	public static final RegistryObject<PaintingType> FLAG_PAINTING= PAINTING_TYPES.register("flag_painting", ()->new PaintingType(64, 48));
}
