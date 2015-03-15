package com.lederpykewlaid.modulargun.main;

import com.lederpykewlaid.modulargun.client.model.ModelM4;
import com.lederpykewlaid.modulargun.item.ModularM4;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class GunHandler {
	
	//public static Item m9;
	//public static Item m1911;
	//public static Item p226;
	
	public static Item m4;
	//public static Item aks74u;
	
	//public static Item m16;
	//public static Item ak47;
	
	public static Item fragGrenade;
	
	//public static Item m82;
	
	public static void register(Item item, String name)
	{
		GameRegistry.registerItem(item, name);
		LanguageRegistry.addName(item, name);
	}
	
	public GunHandler()
	{
		registerGuns();
	}

	public static void registerGuns() 
	{
		/*
		 * These are the guns. I register them this way because it's more organized.
		 */
		//m9 = new ModularM4(15, 1F, 20F, 0, 3F, 1F, false).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("m9").setTextureName("modularguns:m9");
		//register(m9, "M9" + " | " + "Default Gun Pack");
		
		//m1911 = new ModularM4(8, 1F, 20F, 0, 4.5F, 1F, false).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("m1911").setTextureName("modularguns:m1911");
		//register(m1911, "M1911" + " | " + "Default Gun Pack");
		
		//p226 = new ModularM4(12, 1F, 20F, 0, 6F, 1F, false).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("p226").setTextureName("modularguns:p226");
		//register(p226, "P226" + " | " + "Default Gun Pack");
		
		m4 = new ModularM4(31, 0.15F, 3F, 0, 9F, 1F, false).set3DRenderable(new ModelM4(), new ResourceLocation("modularguns:/models/ModelM4.png"), true).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("m4").setTextureName("modularguns:m4");
		register(m4, "M4" + " | " + "Default Gun Pack");
		
		//fragGrenade = new GenericWeaponThrowable(1, 0, 0, 0, 10, ).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("fragGrenade").setTextureName("marko5049_MCW:fragGrendade");
	}

}
