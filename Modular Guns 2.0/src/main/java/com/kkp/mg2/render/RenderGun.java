package com.kkp.mg2.render;

import org.lwjgl.opengl.GL11;

import com.kkp.mg2.weaponry.ItemGun;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

public class RenderGun implements IItemRenderer {
	
	public RenderManager rendermanager;

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) 
	{
		switch (type.ordinal()) 
		{
    		case 1: 
    		case 2: 
    		return true;
		}
	    
		return false;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		
		return false;
		
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data) {
		
		AbstractClientPlayer clientPlayer = Minecraft.getMinecraft().thePlayer;
		ItemGun theGun = (ItemGun)item.getItem();
		ItemGun.ItemWeapon theGun2 = (ItemGun.ItemWeapon)item.getItem();
		
		switch (type.ordinal())
		{
		case 1:
		case 2:
			
			GL11.glPushMatrix();
			
			Minecraft.getMinecraft().renderEngine.bindTexture(theGun2.texture);
			boolean isPlayerFirstPerson = false;
			if ((data[1] != null) && ((data[1] instanceof EntityPlayer))) 
			{
				
		        if (((EntityPlayer)data[1] != Minecraft.getMinecraft().getRenderViewEntity()) || (Minecraft.getMinecraft().gameSettings.thirdPersonView != 0) || ((((Minecraft.getMinecraft().currentScreen instanceof GuiInventory)) || ((Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative))) && (rendermanager.playerViewY == 180.0F)))
		        {
		        	float scale = 0.35F;
			        GL11.glTranslatef(0.25F, 0.25F, 0.06F);
			        GL11.glScalef(scale, scale, scale);
			        GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
			        GL11.glRotatef(150.0F, 1.0F, 0.0F, 0.0F);
			        GL11.glRotatef(15.0F, 0.0F, 1.0F, 0.0F);
			        GL11.glRotatef(-7.0F, 1.0F, 0.0F, 0.0F);
		        }
		        else {
		        	
		        	isPlayerFirstPerson = true;
		        	
		        	
		        	
		        }
			}
		}
	}
}
