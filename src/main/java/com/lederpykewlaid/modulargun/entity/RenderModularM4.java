package com.lederpykewlaid.modulargun.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.gui.inventory.GuiContainerCreative;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.lederpykewlaid.modulargun.client.model.ModelLeftArm;
import com.lederpykewlaid.modulargun.client.model.ModelM4;
import com.lederpykewlaid.modulargun.client.model.ModelRightArm;
import com.lederpykewlaid.modulargun.item.ModularWeapon;

public class RenderModularM4 implements IItemRenderer {
	
	  protected ModelM4 model;
	  protected ModelLeftArm modellefta;
	  protected ModelRightArm modelrighta;
	  
	  public RenderModularM4()
	  {
	    this.model = new ModelM4();
	    this.modelrighta = new ModelRightArm();
	    this.modellefta = new ModelLeftArm();
	  }
	  
	  public boolean handleRenderType(ItemStack item, IItemRenderer.ItemRenderType type)
	  {
	    switch (type.ordinal())
	    {
	    case 1: 
	    case 2: 
	      return true;
	    }
	    return false;
	  }
	  
	  public boolean shouldUseRenderHelper(IItemRenderer.ItemRenderType type, ItemStack item, IItemRenderer.ItemRendererHelper helper)
	  {
	    return false;
	  }
	  
	  public void renderItem(IItemRenderer.ItemRenderType type, ItemStack item, Object... data)
	  {
	    AbstractClientPlayer player = Minecraft.getMinecraft().thePlayer;
	    ModularWeapon weapon = (ModularWeapon)item.getItem();
	    switch (type.ordinal())
	    {
	    case 1: 
	    case 2: 
	      GL11.glPushMatrix();
	      
	      Minecraft.getMinecraft().renderEngine.bindTexture(weapon.texture);
	      boolean isFirtsPerson = false;
	      if ((data[1] != null) && ((data[1] instanceof EntityPlayer))) {
	        if (((EntityPlayer)data[1] != Minecraft.getMinecraft().renderViewEntity) || (Minecraft.getMinecraft().gameSettings.thirdPersonView != 0) || ((((Minecraft.getMinecraft().currentScreen instanceof GuiInventory)) || ((Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative))) && (RenderManager.instance.playerViewY == 180.0F)))
	        {
	          float scale = 0.35F;
	          GL11.glTranslatef(0.25F, 0.25F, 0.06F);
	          GL11.glScalef(scale, scale, scale);
	          GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
	          GL11.glRotatef(150.0F, 1.0F, 0.0F, 0.0F);
	          GL11.glRotatef(15.0F, 0.0F, 1.0F, 0.0F);
	          GL11.glRotatef(-7.0F, 1.0F, 0.0F, 0.0F);
	        }
	        else
	        {
	          isFirtsPerson = true;
	          
	          float scale = 0.7F;
	          GL11.glTranslatef(-0.2F, 0.35F, -0.25F);
	          
	          GL11.glScalef(scale, scale, scale);
	          


	          GL11.glRotatef(100.0F, 0.0F, 1.0F, 0.0F);
	          GL11.glRotatef(150.0F, 1.0F, 0.0F, 0.0F);
	          
	          GL11.glRotatef(25.0F, 0.0F, 1.0F, 0.0F);
	          GL11.glRotatef(6.5F, 0.0F, 0.0F, 1.0F);
	          GL11.glRotatef(-10.0F, 0.0F, 1.0F, 0.0F);
	          GL11.glRotatef(4.1F, 1.0F, 0.0F, 0.0F);
	          GL11.glRotatef(-1.0F, 0.0F, 0.0F, 1.0F);
	          GL11.glRotatef(-1.4F, 0.0F, 1.0F, 0.0F);
	          

	          GL11.glRotatef(-0.5F, 0.0F, 1.0F, 0.0F);
	        }
	      }
	      this.model.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	      
	      GL11.glPopMatrix();
	      
	      GL11.glPushMatrix();
	      


	      Minecraft.getMinecraft().renderEngine.bindTexture(player.getLocationSkin());
	      if ((data[1] != null) && ((data[1] instanceof EntityPlayer))) {
	        if (((EntityPlayer)data[1] != Minecraft.getMinecraft().renderViewEntity) || (Minecraft.getMinecraft().gameSettings.thirdPersonView != 0) || ((((Minecraft.getMinecraft().currentScreen instanceof GuiInventory)) || ((Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative))) && (RenderManager.instance.playerViewY == 180.0F)))
	        {
	          float scale = 0.0F;
	          GL11.glScalef(scale, scale, scale);
	        }
	        else
	        {
	          float scale = 0.7F;
	          GL11.glScalef(2.0F, scale, scale);
	          isFirtsPerson = true;
	          GL11.glTranslatef(0.15F, 0.4F, -2.1F);
	          GL11.glRotatef(-120.0F, 0.0F, 1.0F, 0.0F);
	          GL11.glRotatef(-70.0F, 1.0F, 0.0F, 0.0F);
	          GL11.glRotatef(-30.0F, 0.0F, 0.0F, 1.0F);
	        }
	      }
	      this.modellefta.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	      
	      GL11.glPopMatrix();
	      
	      GL11.glPushMatrix();
	      


	      Minecraft.getMinecraft().renderEngine.bindTexture(player.getLocationSkin());
	      if ((data[1] != null) && ((data[1] instanceof EntityPlayer))) {
	        if (((EntityPlayer)data[1] != Minecraft.getMinecraft().renderViewEntity) || (Minecraft.getMinecraft().gameSettings.thirdPersonView != 0) || ((((Minecraft.getMinecraft().currentScreen instanceof GuiInventory)) || ((Minecraft.getMinecraft().currentScreen instanceof GuiContainerCreative))) && (RenderManager.instance.playerViewY == 180.0F)))
	        {
	          float scale = 0.0F;
	          GL11.glScalef(scale, scale, scale);
	        }
	        else
	        {
	          float scale = 0.7F;
	          GL11.glScalef(2.0F, scale, scale);
	          
	          isFirtsPerson = true;
	          GL11.glTranslatef(-0.7F, -0.8F, -0.45F);
	          GL11.glRotatef(-50.0F, 0.0F, 0.0F, 1.0F);
	        }
	      }
	      this.modelrighta.render((Entity)data[1], 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	      
	      GL11.glPopMatrix();
	    }
	  }
	}

