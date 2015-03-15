package com.lederpykewlaid.modulargun.main;

import com.lederpykewlaid.modulargun.entity.Handler;
import com.lederpykewlaid.modulargun.item.ModularAmmunition;
import com.lederpykewlaid.modulargun.item.ModularM4;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

@Mod(modid = ModProperties.MODID, name = "Modular Guns Mod", version = "0.1.01")
public class ModularWeaponMain {
	
	public static Item ammo;
	
	
	@Mod.Instance(ModProperties.MODID)
	public static ModularWeaponMain instance;
	
	@SidedProxy(clientSide="com.lederpykewlaid.modulargun.main.ClientProxy", serverSide="com.lederpykewlaid.modulargun.main.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent e)
	{
		ammo = new ModularAmmunition().setCreativeTab(CreativeTabs.tabCombat).setTextureName("gunpower");
		GameRegistry.registerItem(ammo, "Ammo");
		LanguageRegistry.addName(ammo, "Ammo");
		GunHandler.registerGuns();
		Handler handler = new Handler();
		FMLCommonHandler.instance().bus().register(handler);
		MinecraftForge.EVENT_BUS.register(handler);
	}
	
	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.load();
	}
	

}
