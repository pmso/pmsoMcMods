package com.pmso.tugaflavours.client.fluids;

import java.util.Random;
import javax.annotation.Nullable;

import com.pmso.tugaflavours.init.ModBlocks;
import com.pmso.tugaflavours.init.ModFluids;
import com.pmso.tugaflavours.init.ModItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.api.distmarker.Dist;

public abstract class WhiteWineFluid extends FlowingFluid {

	ResourceLocation still_texture= new ResourceLocation("tugaflavours:blocks/white_wine_still");
	ResourceLocation flow_texture= new ResourceLocation("tugaflavours:blocks/white_wine_flow");
	ResourceLocation overlay_texture= new ResourceLocation("block/white_wine_overlay");
	
	@Override
	public Fluid getFlowingFluid()
	{
		return ModFluids.WHITE_WINE_FLUID_FLOWING.get();
	}

	@Override
	public Fluid getStillFluid()
	{
		return ModFluids.WHITE_WINE_FLUID.get();
	}

	@Override
	public Item getFilledBucket()
	{
		return ModItems.WHITE_WINE_BUCKET.get();
	}

	@Override
	protected FluidAttributes createAttributes()
	{
		return WineBuilder.builder(
				still_texture,
				flow_texture)
				.overlay(overlay_texture)
				.translationKey("block.tugaflavours.white_wine")
				.build(this);
	}

	@OnlyIn(Dist.CLIENT)
	@Override
	public void animateTick(World world, BlockPos pos, FluidState state, Random random)
	{
		if(!state.isSource() && !state.get(FALLING))
		{
			if(random.nextInt(64) == 0)
				world.playSound(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, SoundEvents.BLOCK_WATER_AMBIENT, SoundCategory.BLOCKS, random.nextFloat() * 0.25F + 0.75F, random.nextFloat() + 0.5F, false);
		}
		else if(random.nextInt(10) == 0)
			world.addParticle(ParticleTypes.UNDERWATER, pos.getX() + random.nextFloat(), pos.getY() + random.nextFloat(), pos.getZ() + random.nextFloat(), 0.0D, 0.0D, 0.0D);
	}

	@Nullable
	@OnlyIn(Dist.CLIENT)
	@Override
	public IParticleData getDripParticleData()
	{
		return ParticleTypes.DRIPPING_WATER;
	}

	@Override
	protected boolean canSourcesMultiply()
	{
		return false;
	}

	@Override
	protected void beforeReplacingBlock(IWorld world, BlockPos pos, BlockState state)
	{
		TileEntity te = state.hasTileEntity() ? world.getTileEntity(pos) : null;

		Block.spawnDrops(state, world, pos, te);
	}

	@Override
	public int getSlopeFindDistance(IWorldReader world)
	{
		return 4;
	}

	@Override
	public BlockState getBlockState(FluidState state)
	{
		return ModBlocks.WHITE_WINE_BLOCK.get().getDefaultState().with(FlowingFluidBlock.LEVEL, getLevelFromState(state));
	}

	@Override
	public boolean isEquivalentTo(Fluid fluid)
	{
		return fluid == ModFluids.WHITE_WINE_FLUID.get() || fluid == ModFluids.WHITE_WINE_FLUID_FLOWING.get();
	}

	@Override
	public int getLevelDecreasePerBlock(IWorldReader world)
	{
		return 1;
	}

	@Override
	public int getTickRate(IWorldReader world)
	{
		return 5;
	}

	@Override
	public boolean canDisplace(FluidState fluidState, IBlockReader world, BlockPos pos, Fluid fluid, Direction dir)
	{
		return dir == Direction.DOWN && !fluid.isIn(FluidTags.WATER);
	}

	@Override
	protected float getExplosionResistance()
	{
		return 100.0F;
	}
	

	public static class Flowing extends WhiteWineFluid
	{
		@Override
		protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder)
		{
			super.fillStateContainer(builder);
			builder.add(LEVEL_1_8);
		}

		@Override
		public int getLevel(FluidState p_207192_1_)
		{
			return p_207192_1_.get(LEVEL_1_8);
		}

		@Override
		public boolean isSource(FluidState state)
		{
			return false;
		}
	}

	public static class Source extends WhiteWineFluid
	{
		@Override
		public int getLevel(FluidState p_207192_1_)
		{
			return 8;
		}

		@Override
		public boolean isSource(FluidState state)
		{
			return true;
		}
	}
 }
