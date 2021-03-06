/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * https://oss.oracle.com/licenses/CDDL+GPL-1.1
 * or LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */

package com.sun.org.omg.SendingContext;


/**
* com/sun/org/omg/SendingContext/_CodeBaseImplBase.java
* Generated by the IDL-to-Java compiler (portable), version "3.0"
* from rt.idl
* Thursday, May 6, 1999 1:52:08 AM PDT
*/

public abstract class _CodeBaseImplBase extends org.omg.CORBA.portable.ObjectImpl
    implements com.sun.org.omg.SendingContext.CodeBase, org.omg.CORBA.portable.InvokeHandler
{

    // Constructors
    public _CodeBaseImplBase ()
    {
    }

    private static java.util.Map<String,Integer> _methods = 
        new java.util.HashMap<String,Integer> ();

    static
    {
        _methods.put ("get_ir", 0);
        _methods.put ("implementation", 1 ) ; 
        _methods.put ("implementations", 2 ) ;
        _methods.put ("meta", 3 ) ;
        _methods.put ("metas", 4 ) ;
        _methods.put ("bases", 5 ) ;
    }

    public org.omg.CORBA.portable.OutputStream _invoke (String method,
                                                        org.omg.CORBA.portable.InputStream in,
                                                        org.omg.CORBA.portable.ResponseHandler rh)
    {
        org.omg.CORBA.portable.OutputStream out = rh.createReply();
        java.lang.Integer __method = _methods.get (method);
        if (__method == null)
            throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

        switch (__method.intValue ())
            {

                // Operation to obtain the IR from the sending context
            case 0:  // SendingContext/CodeBase/get_ir
                {
                    com.sun.org.omg.CORBA.Repository __result = null;
                    __result = this.get_ir ();
                    com.sun.org.omg.CORBA.RepositoryHelper.write (out, __result);
                    break;
                }


                // Operations to obtain a URL to the implementation code
            case 1:  // SendingContext/CodeBase/implementation
                {
                    String x = com.sun.org.omg.CORBA.RepositoryIdHelper.read (in);
                    String __result = null;
                    __result = this.implementation (x);
                    out.write_string (__result);
                    break;
                }

            case 2:  // SendingContext/CodeBase/implementations
                {
                    String x[] = com.sun.org.omg.CORBA.RepositoryIdSeqHelper.read (in);
                    String __result[] = null;
                    __result = this.implementations (x);
                    com.sun.org.omg.SendingContext.CodeBasePackage.URLSeqHelper.write (out, __result);
                    break;
                }


                // the same information
            case 3:  // SendingContext/CodeBase/meta
                {
                    String x = com.sun.org.omg.CORBA.RepositoryIdHelper.read (in);
                    com.sun.org.omg.CORBA.ValueDefPackage.FullValueDescription __result = null;
                    __result = this.meta (x);
                    com.sun.org.omg.CORBA.ValueDefPackage.FullValueDescriptionHelper.write (out, __result);
                    break;
                }

            case 4:  // SendingContext/CodeBase/metas
                {
                    String x[] = com.sun.org.omg.CORBA.RepositoryIdSeqHelper.read (in);
                    com.sun.org.omg.CORBA.ValueDefPackage.FullValueDescription __result[] = null;
                    __result = this.metas (x);
                    com.sun.org.omg.SendingContext.CodeBasePackage.ValueDescSeqHelper.write (out, __result);
                    break;
                }


                // information
            case 5:  // SendingContext/CodeBase/bases
                {
                    String x = com.sun.org.omg.CORBA.RepositoryIdHelper.read (in);
                    String __result[] = null;
                    __result = this.bases (x);
                    com.sun.org.omg.CORBA.RepositoryIdSeqHelper.write (out, __result);
                    break;
                }

            default:
                throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
            }

        return out;
    } // _invoke

    // Type-specific CORBA::Object operations
    private final static String[] __ids = {
        "IDL:omg.org/SendingContext/CodeBase:1.0", 
        "IDL:omg.org/SendingContext/RunTime:1.0"};

    public String[] _ids ()
    {
        return __ids.clone();
    }


} // class _CodeBaseImplBase
