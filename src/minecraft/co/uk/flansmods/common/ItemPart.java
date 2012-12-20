package co.uk.flansmods.common;

import cpw.mods.fml.common.Side;
import cpw.mods.fml.common.asm.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ItemPart extends Item
{
	public ItemPart(int i, PartType type1)
	{
		super(i);
		type = type1;
		setIconIndex(type.iconIndex);
		setMaxStackSize(type.stackSize);
		if (type.category == 9)
		{
			setMaxDamage(type.fuel);
			setHasSubtypes(true);
		}
		type.item = this;
		setCreativeTab(CreativeTabs.tabMaterials);
	}

	public String getTextureFile()
	{
		return "/spriteSheets/parts.png";
	}

    @SideOnly(Side.CLIENT)
    public int getColorFromItemStack(ItemStack par1ItemStack, int par2)
    {
    	return type.colour;
    }

	public PartType type;
}