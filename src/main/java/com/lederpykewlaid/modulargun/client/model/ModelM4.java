package com.lederpykewlaid.modulargun.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelM4 extends ModelBase {
    public ModelRenderer GUShape1;
    public ModelRenderer GUShape2;
    public ModelRenderer GUShape3;
    public ModelRenderer GUShape4;
    public ModelRenderer GUShape5;
    public ModelRenderer AMShape1;
    public ModelRenderer AMShape2;
    public ModelRenderer SCShape1;
    public ModelRenderer SCShape2;
    public ModelRenderer STShape1;
    public ModelRenderer STShape2;
    public ModelRenderer GUShape4_1;
    public ModelRenderer SCShape2_1;
    public ModelRenderer SCShape2_2;
    public ModelRenderer STShape1_1;

    public ModelM4() {
        this.textureWidth = 64;
        this.textureHeight = 16;
        this.STShape1_1 = new ModelRenderer(this, 20, 7);
        this.STShape1_1.setRotationPoint(2.2F, -1.0F, -1.0F);
        this.STShape1_1.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.GUShape2 = new ModelRenderer(this, 0, 6);
        this.GUShape2.setRotationPoint(-1.5F, -5.0F, -1.0F);
        this.GUShape2.addBox(0.0F, 0.0F, 0.0F, 7, 4, 2, 0.0F);
        this.SCShape1 = new ModelRenderer(this, 42, 14);
        this.SCShape1.setRotationPoint(13.0F, -5.5F, -0.5F);
        this.SCShape1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.GUShape3 = new ModelRenderer(this, 24, 2);
        this.GUShape3.setRotationPoint(-1.0F, -2.0F, -0.20000000298023224F);
        this.GUShape3.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(GUShape3, 0.0F, -0.0F, 0.2617993950843811F);
        this.STShape2 = new ModelRenderer(this, 20, 7);
        this.STShape2.setRotationPoint(-7.5F, -5.0F, -1.0F);
        this.STShape2.addBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
        this.STShape1 = new ModelRenderer(this, 20, 7);
        this.STShape1.setRotationPoint(-7.5F, -4.0F, -1.0F);
        this.STShape1.addBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
        this.SCShape2_1 = new ModelRenderer(this, 37, 14);
        this.SCShape2_1.setRotationPoint(-1.0F, -5.5F, -0.5F);
        this.SCShape2_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.setRotateAngle(SCShape2_1, -3.061573459363132E-16F, 0.0F, 0.0F);
        this.SCShape2 = new ModelRenderer(this, 37, 14);
        this.SCShape2.setRotationPoint(-1.0F, -6.0F, -0.5F);
        this.SCShape2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, -0.3F);
        this.SCShape2_2 = new ModelRenderer(this, 20, 7);
        this.SCShape2_2.setRotationPoint(0.0F, -0.5F, -1.0F);
        this.SCShape2_2.addBox(0.0F, 0.0F, 0.0F, 3, 1, 2, -0.3F);
        this.GUShape5 = new ModelRenderer(this, 0, 2);
        this.GUShape5.setRotationPoint(5.800000190734863F, -5.0F, -1.0F);
        this.GUShape5.addBox(0.0F, 0.0F, 0.0F, 6, 2, 2, 0.0F);
        this.GUShape1 = new ModelRenderer(this, 31, 2);
        this.GUShape1.setRotationPoint(-1.0F, -2.0F, -0.800000011920929F);
        this.GUShape1.addBox(0.0F, 0.0F, 0.0F, 2, 4, 1, 0.0F);
        this.setRotateAngle(GUShape1, 0.0F, -0.0F, 0.2617993950843811F);
        this.AMShape1 = new ModelRenderer(this, 18, 12);
        this.AMShape1.setRotationPoint(2.3F, 1.5F, -0.75F);
        this.AMShape1.addBox(0.0F, 0.0F, 0.0F, 3, 3, 1, 0.0F);
        this.setRotateAngle(AMShape1, 0.0F, 0.0F, -0.20943951023931953F);
        this.GUShape4 = new ModelRenderer(this, 0, 0);
        this.GUShape4.setRotationPoint(5.0F, -4.5F, -0.5F);
        this.GUShape4.addBox(0.0F, 0.0F, 0.0F, 10, 1, 1, 0.0F);
        this.AMShape2 = new ModelRenderer(this, 9, 13);
        this.AMShape2.setRotationPoint(2.3F, -0.5F, -0.75F);
        this.AMShape2.addBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
        this.GUShape4_1 = new ModelRenderer(this, 0, 0);
        this.GUShape4_1.setRotationPoint(-7.1F, -4.5F, -0.5F);
        this.GUShape4_1.addBox(0.0F, 0.0F, 0.0F, 10, 1, 1, 0.2F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GL11.glPushMatrix();
        GL11.glTranslatef(this.STShape1_1.offsetX, this.STShape1_1.offsetY, this.STShape1_1.offsetZ);
        GL11.glTranslatef(this.STShape1_1.rotationPointX * f5, this.STShape1_1.rotationPointY * f5, this.STShape1_1.rotationPointZ * f5);
        GL11.glScaled(1.1D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.STShape1_1.offsetX, -this.STShape1_1.offsetY, -this.STShape1_1.offsetZ);
        GL11.glTranslatef(-this.STShape1_1.rotationPointX * f5, -this.STShape1_1.rotationPointY * f5, -this.STShape1_1.rotationPointZ * f5);
        this.STShape1_1.render(f5);
        GL11.glPopMatrix();
        this.GUShape2.render(f5);
        this.SCShape1.render(f5);
        this.GUShape3.render(f5);
        this.STShape2.render(f5);
        this.STShape1.render(f5);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 0.9990000000000001F);
        this.SCShape2_1.render(f5);
        GL11.glDisable(GL11.GL_BLEND);
        this.SCShape2.render(f5);
        this.SCShape2_2.render(f5);
        this.GUShape5.render(f5);
        this.GUShape1.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.AMShape1.offsetX, this.AMShape1.offsetY, this.AMShape1.offsetZ);
        GL11.glTranslatef(this.AMShape1.rotationPointX * f5, this.AMShape1.rotationPointY * f5, this.AMShape1.rotationPointZ * f5);
        GL11.glScaled(1.0D, 1.0D, 1.5D);
        GL11.glTranslatef(-this.AMShape1.offsetX, -this.AMShape1.offsetY, -this.AMShape1.offsetZ);
        GL11.glTranslatef(-this.AMShape1.rotationPointX * f5, -this.AMShape1.rotationPointY * f5, -this.AMShape1.rotationPointZ * f5);
        this.AMShape1.render(f5);
        GL11.glPopMatrix();
        this.GUShape4.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.AMShape2.offsetX, this.AMShape2.offsetY, this.AMShape2.offsetZ);
        GL11.glTranslatef(this.AMShape2.rotationPointX * f5, this.AMShape2.rotationPointY * f5, this.AMShape2.rotationPointZ * f5);
        GL11.glScaled(1.0D, 1.0D, 1.5D);
        GL11.glTranslatef(-this.AMShape2.offsetX, -this.AMShape2.offsetY, -this.AMShape2.offsetZ);
        GL11.glTranslatef(-this.AMShape2.rotationPointX * f5, -this.AMShape2.rotationPointY * f5, -this.AMShape2.rotationPointZ * f5);
        this.AMShape2.render(f5);
        GL11.glPopMatrix();
        this.GUShape4_1.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
