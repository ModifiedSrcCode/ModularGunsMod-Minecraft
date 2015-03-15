package com.lederpykewlaid.modulargun.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import org.lwjgl.input.Mouse;

import com.lederpykewlaid.modulargun.client.model.ModelM4;
import com.lederpykewlaid.modulargun.entity.EntityBullet;

public class ModularM4 extends ModularWeapon {
	
	public int ammoAmount;
	public float recoil;
	public float fireDelay;
	public float shotDelay;
	public float reloadTime;
	public float damage;
	public ModelM4 model;
	public boolean explosive;
	public int shootButtonId = 0;
	public int aimButtonId = 1;
	public static boolean isShootButtonDown;
	public static boolean isAimButtonDown;
	private EntityPlayer player;
	public static ScaledResolution scaledresolution;
	public ModularAmmunition ammo;
	public float zoomAmt;
	
	public float minZoom = 7;
	public float maxZoom = 69;
	private float currentAmmo = 0;
	private float originalFOV = 69;
	private float currentRecoil = 0;
	
	public boolean isZoomed = false;
	private int zoomTick;
	
	public ModularM4(int aA, float r, float fD, float rT, float d, float zA, boolean e)
	{
		this.ammoAmount = aA;
		this.recoil = r;
		this.fireDelay = fD;
		this.shotDelay = fD;
		this.reloadTime = rT;
		this.damage = d;
		this.zoomAmt = zA;
		this.explosive = e;
		this.bFull3D = true; 
	}
	
	public void onUpdate(ItemStack stack, World world, Entity entity, int i, boolean isSelected)
	{
		if(entity instanceof EntityPlayer && ((EntityPlayer)entity).inventory.getCurrentItem() == stack) 
		{
			EntityPlayer player = (EntityPlayer)entity;
			isShootButtonDown = Mouse.isButtonDown(shootButtonId);
			isAimButtonDown = Mouse.isButtonDown(aimButtonId);
			
			fireDelay++;
			
			if(isShootButtonDown)
			{
				shoot(stack, world, player);
				player.cameraPitch = recoil - recoil * 2;
			}
			
			//In the works!
			/*if(isAimButtonDown && this.zoomTick-- <= 0) {
				this.isZoomed = !this.isZoomed;
				if(this.isZoomed)
				{
					originalFOV = Minecraft.getMinecraft().gameSettings.fovSetting;
				} 
				else if(!this.isZoomed) 
				{
					Minecraft.getMinecraft().gameSettings.fovSetting = originalFOV;
				}
				this.zoomTick = 3;
			}*/
			
			if(currentRecoil > 0) {
				Minecraft.getMinecraft().thePlayer.renderArmPitch -= currentRecoil * 72F;
				Minecraft.getMinecraft().thePlayer.renderArmYaw += currentRecoil * 48F;
				
				currentRecoil -= 0.4;
			}
			if(currentRecoil < 0) currentRecoil = 0;
		}
	}
	
	
	public ItemStack shoot(ItemStack stack, World world, EntityPlayer player) 
	{
		if(fireDelay >= shotDelay)
		{
			if(!world.isRemote)
			{
				world.spawnEntityInWorld(new EntityBullet(world, player, damage, explosive));
				world.playSoundEffect(20, 70, 20, "modularguns:m4shoot", 1, 1);
				fireDelay = 0;
				ammoAmount--;
				currentRecoil = recoil;
			}
			
			else if(getCurrentAmmo(stack) < 1)
			{
				world.playSoundAtEntity(player, "fire.ignite", 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
				if(player.inventory.hasItem(ammo) || player.capabilities.isCreativeMode)
				{
					currentAmmo = ammoAmount;
				}
			}
		}
		return stack;
	}
	
	
	//In the works!
	/*public void zoom(int scrollAmt)
	{
		Minecraft mc = FMLClientHandler.instance().getClient();
		if(mc.gameSettings.fovSetting < minZoom) mc.gameSettings.fovSetting = minZoom;
		if(mc.gameSettings.fovSetting > maxZoom) mc.gameSettings.fovSetting = maxZoom;
	}*/
	
	
	public int setAmmoAmt(int ammo)
	{
		this.setMaxDamage(ammo);		
		return this.ammoAmount;
	}
	
	public void reload()
	{
	}
	
	public int getCurrentAmmo(ItemStack stack)
	{
		return getDamage(stack);
	}
		
	@Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack)
    {
        return true;
    }
	
	@Override
    public boolean onBlockStartBreak(ItemStack itemstack, int X, int Y, int Z, EntityPlayer player)
    {
        return true;
    }
	

}
