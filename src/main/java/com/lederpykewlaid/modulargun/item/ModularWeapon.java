package com.lederpykewlaid.modulargun.item;

import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class ModularWeapon extends Item {
	public ModelBase model;
	public ResourceLocation texture;
	public boolean is3D = false;
	
	public Item set3DRenderable(ModelBase model, ResourceLocation texture, boolean is3D) {
		this.model = model;
		this.texture = texture;
		this.is3D = is3D;
		return this;
	}
	
}
