package com.lederpykewlaid.modulargun.entity;

import java.util.List;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.server.FMLServerHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {

	public int fuse = 20;
	private Entity exploder;
	private EntityPlayer player;
	private float speed;
	private float damage;
	public EntityGrenade(World par1World, EntityLivingBase par2EntityLivingBase, float speed, float damage) {
		super(par1World, par2EntityLivingBase);
		exploder = par2EntityLivingBase;
		player = (EntityPlayer)par2EntityLivingBase;
	}
	
	public void onUpdate()
	{
		super.onUpdate();
		if(!this.worldObj.isRemote)
		{
			if(--fuse == 0)
			{
				float exSize = 5F;
				this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, 0.25F, true);
				int i = MathHelper.floor_double(this.posX - (double)exSize - 1.0D);
				int j = MathHelper.floor_double(this.posX + (double)exSize + 1.0D);
				int k = MathHelper.floor_double(this.posY - (double)exSize - 1.0D);
		        int l1 = MathHelper.floor_double(this.posY + (double)exSize + 1.0D);
		        int i2 = MathHelper.floor_double(this.posZ - (double)exSize - 1.0D);
		        int j2 = MathHelper.floor_double(this.posZ + (double)exSize + 1.0D);
				List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this.exploder, AxisAlignedBB.getBoundingBox((double)i, (double)k, (double)i2, (double)j, (double)l1, (double)j2));
				double d0 = this.posX;
				double d1 = this.posY;
				double d2 = this.posZ;
				for (int k2 = 0; k2 < list.size(); ++k2)
		        {
		            Entity entity = (Entity)list.get(k2);
		            double d7 = entity.getDistance(this.posX, this.posY, this.posZ) / (double)exSize;

		            if (d7 <= 1.0D)
		            {
		                d0 = entity.posX - this.posX;
		                d1 = entity.posY + (double)entity.getEyeHeight() - this.posY;
		                d2 = entity.posZ - this.posZ;
		                double d8 = (double)MathHelper.sqrt_double(d0 * d0 + d1 * d1 + d2 * d2);

		                if (d8 != 0.0D)
		                {
		                    d0 /= d8;
		                    d1 /= d8;
		                    d2 /= d8;
		                    double d10 = (1.0D - d7);
		                    float distance = entity.getDistanceToEntity(this) / 2;
		                    entity.attackEntityFrom(DamageSource.causePlayerDamage(player), 25F - distance);
		                    double d11 = EnchantmentProtection.func_92092_a(entity, d10);
		                    entity.motionX += d0 * d11;
		                    entity.motionY += d1 * d11;
		                    entity.motionZ += d2 * d11;
		                }
		            }
		        }
				this.setDead();
			}
		}
		if(this.worldObj.isRemote)
		{
			this.worldObj.spawnParticle("smoke", posX, posY, posZ, motionX, motionY, motionZ);
		}
		if(this.ticksExisted > 2000)
		{
			this.setDead();
		}
	}
	
	@Override
	protected void onImpact(MovingObjectPosition movingobjectposition) 
	{
		if (movingobjectposition.entityHit instanceof EntityLivingBase)
		{
			EntityLivingBase et = ((EntityLivingBase)movingobjectposition.entityHit);
			DamageSource ds = DamageSource.causeMobDamage(et);
			et.attackEntityFrom(ds, damage);
		}
		this.speed = -0.1f;
	}
}
