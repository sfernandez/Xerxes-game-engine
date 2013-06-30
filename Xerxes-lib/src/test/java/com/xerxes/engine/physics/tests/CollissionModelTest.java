package com.xerxes.engine.physics.tests;

import com.xerxes.engine.physics.CollisionModel;
import com.xerxes.engine.ui.Position;

import junit.framework.TestCase;

public class CollissionModelTest extends TestCase
{
	public void test_CollidesWith_whenCollisionModelIsASquare_andTestPointIsOutsideTheSquare_shouldReturnFalse()
	{
		CollisionModel sut = getSquareCollisionModel();
		Position testPosition = new Position(20.0,15.0,1);
		assertFalse("incorrect position",sut.collidesWith(testPosition));
	}
	private CollisionModel getSquareCollisionModel() 
	{
		CollisionModel sut = new CollisionModel(new Position[]{new Position(0.0,0.0,1),new Position(0.0,10.0,1), new Position(10.0,10.0,1),new Position(10.0,0.0,1)});
		return sut;
	}
	public void test_CollidesWith_whenCollisionModelIsASquare_andTestPointIsInsideTheSquare_shouldReturnTrue()
	{
		CollisionModel sut = getSquareCollisionModel();
		Position testPosition = new Position(5.0,5.0,1);
		boolean actual = sut.collidesWith(testPosition);
		assertTrue("incorrect position",actual);
	}
	/*public void test_CollidesWith_whenCollisionModelIsATriange_andTestPointIsInsideTheTriangle_shouldReturnTrue()
	{
		CollisionModel sut = getTriangleCollisionModel();
		Position testPosition = new Position(5.0,5.0,1);
		boolean actual = sut.collidesWith(testPosition);
		assertTrue("incorrect position",actual);
	}
	private CollisionModel getTriangleCollisionModel() 
	{
		CollisionModel sut = new CollisionModel(new Position[]{new Position(0.0,0.0,1),new Position(5.0,10.0,1),new Position(10.0,0.0,1)});
		return sut;
	}
	public void test_CollidesWith_whenCollisionModelIsATriangle_andTestPointIsOutsideTheTriangle_shouldReturnFalse()
	{
		CollisionModel sut = getTriangleCollisionModel();
		Position testPosition = new Position(0.0,4.0,1);
		assertFalse("incorrect position",sut.collidesWith(testPosition));
	}*/
	
}
