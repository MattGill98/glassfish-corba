package org.omg.CORBA;


/**
* org/omg/CORBA/StructMember.java .
* IGNORE Generated by the IDL-to-Java compiler (portable), version "3.2"
* from idlj/src/main/java/com/sun/tools/corba/ee/idl/ir.idl
* IGNORE Sunday, January 21, 2018 1:54:22 PM EST
*/

public final class StructMember implements org.omg.CORBA.portable.IDLEntity
{
  public String name = null;
  public org.omg.CORBA.TypeCode type = null;
  public org.omg.CORBA.IDLType type_def = null;

  public StructMember ()
  {
  } // ctor

  public StructMember (String _name, org.omg.CORBA.TypeCode _type, org.omg.CORBA.IDLType _type_def)
  {
    name = _name;
    type = _type;
    type_def = _type_def;
  } // ctor

} // class StructMember