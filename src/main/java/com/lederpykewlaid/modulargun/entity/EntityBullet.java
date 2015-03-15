package com.lederpykewlaid.modulargun.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable {
	
	public float damage;
	public float velocity = 0F;
	public float speed = 60F;
	public boolean explosive = false;
	private EntityLivingBase shooter;

	public EntityBullet(World world) {
		super(world);
	}
	
	public EntityBullet(World world, EntityLivingBase entityLiving, float dmg, boolean explosive)
	{
		super(world, entityLiving);
		this.damage = dmg;
		this.explosive = explosive;
		this.shooter = entityLiving;
		this.posX -= (double)(MathHelper.cos(entityLiving.rotationYaw / 180.0F * (float)Math.PI) * 0.46F);
        this.posZ -= (double)(MathHelper.sin(entityLiving.rotationYaw / 180.0F * (float)Math.PI) * 0.46F);
	}
	
	public EntityBullet(World world, double d2, double d4, double d6)
	{
		super(world, d2, d4, d6);
	}

	@Override
	protected void onImpact(MovingObjectPosition mob) {
		
		if(mob.entityHit != null)
		{	
			float dmg = 0;
			if(mob.entityHit instanceof EntityLivingBase && (EntityLivingBase)mob.entityHit != shooter)
			{
				this.worldObj.playSoundAtEntity(getThrower(), "fire.ignite", 0.5F, 0.4F);
				this.worldObj.spawnParticle("reddust", 1.5D, 1.5D, 1.5D, 0.0D, 0.0D, 0.0D);
				dmg = this.damage;
				if(!this.explosive) this.setDead();
			}
			mob.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), dmg);
		}
		if(this.explosive)
		{
			if(mob.typeOfHit == MovingObjectType.BLOCK) this.worldObj.createExplosion(this, mob.blockX, mob.blockY, mob.blockZ, 2.5F, true);
			else if(mob.typeOfHit == MovingObjectType.ENTITY) this.worldObj.createExplosion(this, mob.entityHit.posX, mob.entityHit.posY, mob.entityHit.posZ, 2.5F, true);
			this.setDead();
		}
		
	}
	
	@Override
	protected float getGravityVelocity()
	{
		this.motionX *= speed;
		this.motionY *= speed;
		this.motionZ *= speed;
		return 0F;
	}

}
