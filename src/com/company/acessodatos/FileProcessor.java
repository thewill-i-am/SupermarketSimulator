package com.company.acessodatos;

import com.company.modelos.GestorColas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public abstract class FileProcessor {
        protected String fileName;

        public FileProcessor(String fileName) {
            this.fileName = fileName;
        }

        public GestorColas processFile() throws FileNotFoundException {
            Scanner reader = openFile();
            GestorColas gestorColas = readLines(reader);
            reader.close();
            return gestorColas;
        }

        protected Scanner openFile() throws FileNotFoundException {
            return new Scanner(new File(fileName));
        }

        protected abstract GestorColas readLines(Scanner reader) throws FileNotFoundException;
}
