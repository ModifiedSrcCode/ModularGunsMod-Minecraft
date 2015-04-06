package com.kkp.mg2.weaponry.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.MovingObjectPosition.MovingObjectType;
import net.minecraft.world.World;

public class EntityBullet extends EntityThrowable{
	
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
				dmg = this.damage;
				if(!this.explosive) this.setDead();
			}
			mob.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), dmg);
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