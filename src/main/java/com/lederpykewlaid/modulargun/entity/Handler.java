package com.lederpykewlaid.modulargun.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.MouseEvent;

import org.lwjgl.opengl.GL11;

import com.lederpykewlaid.modulargun.item.ModularM4;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Handler {
	
	public Handler() {}
	
	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {

	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTick(TickEvent.ClientTickEvent event) {
		
	}
	 
	@SubscribeEvent
	public void onServerTick(TickEvent.ServerTickEvent event) {

	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onRenderTick(TickEvent.RenderTickEvent event) 
	{
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.thePlayer != null) 
		{
			if(mc.thePlayer.getHeldItem() != null) {
				if(mc.thePlayer.getHeldItem().getItem() instanceof ModularM4) 
				{
					ModularM4 weapon = ((ModularM4)mc.thePlayer.getHeldItem().getItem());
					if(weapon.isZoomed) 
					{
						
					}
				}
			}
		}
	}
	 
	@SubscribeEvent
	public void onWorldTick(TickEvent.WorldTickEvent event) 
	{

	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onMouseEvent(MouseEvent event) 
	{
		Minecraft mc = Minecraft.getMinecraft();
	}
	
}
