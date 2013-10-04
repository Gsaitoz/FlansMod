package co.uk.flansmods.common.driveables.mechas;

import java.util.ArrayList;

import co.uk.flansmods.common.TypeFile;
import co.uk.flansmods.common.driveables.DriveableType;

public class MechaType extends DriveableType 
{
	/** Movement modifiers */
	public float turnLeftModifier = 1F, turnRightModifier = 1F, moveSpeed = 1F;
	/** If true, this will crush any living entity under the wheels */
	public boolean squashMobs = false;
	/** How many blocks can be stepped up when walking */
	public int stepHeight = 0;
	/** Jump Height (set 0 for no jump) */
	public float jumpHeight = 1F;
	public float jumpVelocity = 1F;
	/** Speed of Rotation */
	public float rotateSpeed = 10F;
	/** Origin of the mecha arms */
	
	public static ArrayList<MechaType> types = new ArrayList<MechaType>();

	public MechaType(TypeFile file)
	{
		super(file);
		types.add(this);
	}

    @Override
	protected void read(String[] split, TypeFile file)
    {
		super.read(split, file);
		try
		{
			//Movement modifiers
			if(split[0].equals("TurnLeftSpeed"))
				turnLeftModifier = Float.parseFloat(split[1]);
			if(split[0].equals("TurnRightSpeed"))
				turnRightModifier = Float.parseFloat(split[1]);
			if(split[0].equals("MoveSpeed"))
				moveSpeed = Float.parseFloat(split[1]);
			if(split[0].equals("SquashMobs"))
				squashMobs = Boolean.parseBoolean(split[1].toLowerCase());
			if(split[0].equals("StepHeight"))
				stepHeight = Integer.parseInt(split[1]);
			if(split[0].equals("JumpHeight"))
			{
				jumpHeight = Float.parseFloat(split[1]);
				jumpVelocity = (float) Math.sqrt(Math.abs(9.81F * (jumpHeight + 0.2F) / 200F));
			}
			if(split[0].equals("RotateSpeed"))
				rotateSpeed = Float.parseFloat(split[1]);
		}
		catch (Exception e)
		{
		}
    }
    
	public static MechaType getMecha(String find)
	{
		for(MechaType type : types)
		{
			if(type.shortName.equals(find))
				return type;
		}
		return null;
	}
}