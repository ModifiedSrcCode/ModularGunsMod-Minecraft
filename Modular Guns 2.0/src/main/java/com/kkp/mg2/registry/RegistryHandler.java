package com.kkp.mg2.registry;

import com.kkp.mg2.weaponry.ItemGun;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.LanguageRegistry;

public class RegistryHandler {
	
	public static void registerGun(Item item, String name)
	{
		GameRegistry.registerItem(item, name);
		LanguageRegistry.addName(item, name);
	}

}
