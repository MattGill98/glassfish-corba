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

package corba.cdrext;

import java.io.*;
import java.util.*;

public class CustomMarshalTester extends MarshalTester implements Serializable
{
    private transient List items;

    public CustomMarshalTester() {
        items = new LinkedList();
    }

    public void add(Object obj) {
        items.add(obj);
    }

    public Iterator iterator() {
        return items.iterator();
    }

    public boolean equals(Object obj) {
        try {
            return super.equals(obj) 
                && items.equals(((CustomMarshalTester)obj).items);
        } catch (ClassCastException cce) {
            cce.printStackTrace();
            return false;
        }
    }

    public int size() {
        return items.size();
    }

    private void writeObject(ObjectOutputStream s) throws IOException {

        s.defaultWriteObject();

        s.writeInt(size());

        Iterator iter = iterator();

        while (iter.hasNext())
            s.writeObject(iter.next());
    }
    
    private void readObject(java.io.ObjectInputStream s)
        throws IOException, ClassNotFoundException {

        if (items != null)
            throw new IOException("Default constructor was invoked [1]!");

        s.defaultReadObject();

        if (items != null)
            throw new IOException("Default constructor was invoked [2]!");

        int numItems = s.readInt();

        items = new LinkedList();

        for (int i = 0; i < numItems; i++)
            items.add(s.readObject());
    }
}

