package com.arcologydesigns.ept.users;

import com.sun.org.apache.xpath.internal.functions.FuncFalse;
import com.sun.prism.shader.Solid_ImagePattern_Loader;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * StudentTest created by Borislav S. on 7/24/2015 @ 7:37 PM.
 */
public class StudentTest {

   @Before
   public void setUp() throws Exception {

   }

    @After
   public void tearDown() throws Exception {



   }

   @Test
   public void testCompareTo() throws Exception {
      Student foo = new Student("Bob", 0);
      foo.setUserID("ID");
      foo.setUserName("foo");
      foo.setPhone("Phone");
      foo.setAddress("Address");
      foo.setEmail("Email");

      Student bar = new Student("", 0);
      bar.setUserID("ID");
      bar.setUserName("Bar");
      bar.setPhone("Phone");
      bar.setAddress("Address");
      bar.setEmail("Email");
      System.out.println("Bar is:"+ bar);

      int test = foo.compareTo(bar);
      assert (test != 1);



   }

   @Test
   public void testToString() throws Exception {

      Student foo = new Student ( "Jacob" , 94);
      foo.setUserID("Password");
      foo.setUserName("John");
      foo.setPhone("Phone");
      foo.setAddress("Address");
      foo.setEmail("Email");
      String Bar = foo.toString();
      assertEquals("Password,John,Phone,Address,Email;", Bar);


   }

   @Test
   public void testFullStringRep() throws Exception {
      Student foo = new Student("John", 85);


      assertEquals("John: 85.0", foo.fullStringRep());

   }

   @Test
   public void testEquals() throws Exception {
      Student foo = new Student("Bob", 0);
      foo.setUserID("ID");
      foo.setUserName("foo");
      foo.setPhone("Phone");
      foo.setAddress("Address");
      foo.setEmail("Email");

      Student foo2= foo;

      boolean test = foo.equals(foo2);
      assertEquals (foo, foo2);
   }





}