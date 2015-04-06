package com.kkp.mg2.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelLeftArm extends ModelBase {
	
	  public ModelRenderer LeftArm;
	  
	  public ModelLeftArm()
	  {
	    this.textureWidth = 64;
	    this.textureHeight = 32;
	    this.LeftArm = new ModelRenderer(this, 40, 16);
	    this.LeftArm.mirror = true;
	    this.LeftArm.setRotationPoint(5.0F, 2.0F, 0.0F);
	    this.LeftArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
	  }
	  
	  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	  {
	    GL11.glPushMatrix();
	    GL11.glScaled(1.0D, 2.5D, 1.0D);
	    this.LeftArm.render(f5);
	    GL11.glPopMatrix();
	  }
	  
	  public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z)
	  {
	    modelRenderer.rotateAngleX = x;
	    modelRenderer.rotateAngleY = y;
	    modelRenderer.rotateAngleZ = z;
	  }

}
