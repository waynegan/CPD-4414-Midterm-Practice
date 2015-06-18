/*
 * Copyright 2015 Len Payne <len.payne@lambtoncollege.ca>.
 * Updated 2015 Mark Russell <mark.russell@lambtoncollege.ca>s
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Note;

/**
 * Provides an Account Balance and Basic Withdrawal/Deposit Operations
 */
@WebServlet("/note")
public class NoteServlet extends HttpServlet {
    Note myNote = new Note();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) {
 response.setHeader("Cache-Control", "private, no-store, no-cache, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        try (PrintWriter out = response.getWriter()) {
           
           String something=myNote.getNote();
            out.println(something);
            
        } catch (IOException ex) {
            System.err.println("Something Went Wrong: " + ex.getMessage());
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) {

        String addWord = request.getParameter("add");   
        String setWord = request.getParameter("set");  
        String doClear = request.getParameter("clear");
        if (doClear != null)
            myNote.clear();
        if (addWord != null)
            myNote.addNote(addWord);
        if (setWord != null)
            myNote.setNote(setWord);
    }
}
