/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class LocalAppData {

    public void VerificaLocal() throws IOException {
        File Arquivo = new File(System.getenv("APPDATA") + "/Projeto_TCC/Config.txt");
        if (!Arquivo.exists()) {
            System.out.println("Arquivo AppData nao existe");
        } else {
            System.out.println("Arquivo AppData existe");

        }
        FileWriter Arq = new FileWriter(System.getenv("APPDATA") + "/Projeto_TCC/Config.txt");
        PrintWriter gravarArq = new PrintWriter(Arq);
        gravarArq.printf("------------------------ Caminhos Para Gravação de Arquivos e Backups (NAO MODIFICAR) ------------------------%n");
        gravarArq.printf("%n");
        gravarArq.printf("* Backup ->%n");
        gravarArq.printf("* Relatórios ->%n");
        gravarArq.printf("%n");
        gravarArq.printf("Obs:Colocar o caminho sem espaços e utilizando a / e nao a \\%n");
        gravarArq.printf("%n");
        gravarArq.printf("-----------------------------------------------------------------------------------------------%n");
        Arq.close();
    }

    public void LerArquivo() throws FileNotFoundException, IOException {
        Scanner scanner = new Scanner(new FileReader(System.getenv("APPDATA") + "/Projeto_TCC/Config.txt")).useDelimiter("\\->|\\n");
        String CaminhoBackup = null, CaminhoRelatorio = null, Nula = null;
        while (scanner.hasNext()) {
            Nula = scanner.next();
            Nula = scanner.next();
            Nula = scanner.next();
            CaminhoBackup = scanner.next();
            Nula = scanner.next();
            CaminhoRelatorio = scanner.next();
            Nula = scanner.next();
            Nula = scanner.next();
            Nula = scanner.next();
            Nula = scanner.next();
            System.setProperty("CaminhoBackup", CaminhoBackup);
            System.setProperty("CaminhoRelatorio", CaminhoRelatorio);
            System.out.println("backup-" + CaminhoBackup);
            System.out.println("relatorio-" + CaminhoRelatorio);
        }
        scanner.close();

    }

}
