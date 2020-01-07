/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Rectangle;
import com.lowagie.text.Table;
import static com.lowagie.text.Utilities.millimetersToPoints;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.jdesktop.swingx.JXTable;

/**
 *
 * @author Efraim
 */
public class GerarPDF {

    public void criarPDF(JXTable XTabela, String nomeArquivo) throws BadElementException {
        Document document = new Document(PageSize.A4.rotate(), 1, 1, 1, 1);
        try {
            int Coluna, Linha;
            Coluna = XTabela.getColumnCount();
            Linha = XTabela.getRowCount();
            System.out.println("Número de colunas " + XTabela.getColumnCount());
            System.out.println("Número de linhas " + XTabela.getRowCount());
            System.out.println("------------------------");

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("APPDATA") + "/Projeto_TCC/" + nomeArquivo + ".pdf"));
            document.open();

            //metadados
            document.addSubject(nomeArquivo);
            document.addCreator("Gerenciador Comercial - J.C Tramontina");
            document.addAuthor("Efraim de CArvalho Felix");

            Font fonteTexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL, new Color(0, 0, 0));
            Font fonteNegrito = FontFactory.getFont(FontFactory.COURIER, 8.5f, Font.BOLD, new Color(255, 255, 255));

            Table tabela = new Table(Coluna);
            tabela.setBackgroundColor(new Color(0, 153, 255));
            tabela.setPadding(0.5f);
            tabela.setAlignment(Element.ALIGN_CENTER);
            tabela.setAlignment(Element.ALIGN_MIDDLE);
            tabela.setWidth(100f);
            tabela.setWidths(getTamanhoColunas(XTabela));
            tabela.setCellsFitPage(true);
            tabela.setBorderColor(new Color(0, 64, 136));

            // set um cabecalho
            Cell cabecalho = new Cell(new Paragraph(nomeArquivo));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBackgroundColor(new Color(0, 64, 136));
            cabecalho.setColspan(Coluna);
            tabela.addCell(cabecalho);

            // coloca na tabela as colunas que estavam na JTable
            for (int col1 = 0; col1 < Coluna; col1++) {
                Cell coluna = new Cell(new Paragraph(XTabela.getColumnName(col1), fonteNegrito));
                coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
                coluna.setBackgroundColor(new Color(0, 102, 255));
                coluna.setColspan(1);
                coluna.setBorderColor(new Color(0, 64, 136));
                tabela.addCell(coluna);
            }
            // coloca na tabela as linhas que estavam na JTable
            for (int lin = 0; lin < Linha; lin++) {
                for (int col2 = 0; col2 < Coluna; col2++) {
                    Cell celula = new Cell(new Paragraph(String.valueOf(XTabela.getValueAt(lin, col2)), fonteTexto));
                    celula.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celula.setBorderColor(new Color(0, 64, 136));
                    tabela.addCell(celula);
                }
            }
            document.add(tabela);

        } catch (FileNotFoundException | DocumentException ex) {
            System.out.println(ex);
        } finally {
            document.close();
        }
    }

    public float[] getTamanhoColunas(JXTable XTabela) {

        int Coluna;
        Coluna = XTabela.getColumnCount();

        float tamanhoColuna[] = new float[Coluna];
        float tamanhoColunaRetorno[] = new float[Coluna];
        for (int i = 0; i < Coluna; i++) {
            tamanhoColuna[i] = XTabela.getColumn(i).getWidth();
        }

        int total = 0;
        for (int i = 0; i < Coluna; i++) {

            total += tamanhoColuna[i];
            System.out.println("Total - " + total);
            System.out.println("-----------------------------------");
        }

        for (int i = 0; i < Coluna; i++) {
            tamanhoColunaRetorno[i] = ((float) 100 * (float) tamanhoColuna[i]) / (float) total;
        }
        return tamanhoColunaRetorno;
    }

    public int getTamanho(int[] TamanhoColunas, int QtdColuna) {
        int total = 0;
        for (int i = 0; i < QtdColuna; i++) {

            total += TamanhoColunas[i];
            System.out.println("Total - " + total);
            System.out.println("-----------------------------------");
        }
        return total;
    }

    public void abrirPDF(String arquivoPDF) throws IOException, InterruptedException {
        Process pro = Runtime.getRuntime().exec("cmd.exe /c   " + System.getenv("APPDATA") + "/Projeto_TCC/"+arquivoPDF+".pdf");
        pro.waitFor();
    }

    public void criarCupom(JXTable XTabela, String nomeArquivo) {
        Rectangle pagesize = new Rectangle(240f, 720f);
        Document document = new Document(pagesize,1,1,1,1);
        try {

            int Coluna, Linha;
            Coluna = XTabela.getColumnCount();
            Linha = XTabela.getRowCount();

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(System.getenv("APPDATA") + "/Projeto_TCC/" + nomeArquivo + ".pdf"));
            document.open();

            //metadados
            document.addSubject(nomeArquivo);
            document.addCreator("Gerenciador Comercial - J.C Tramontina");
            document.addAuthor("Efraim de CArvalho Felix");

            Font fonteTexto = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, Font.NORMAL, new Color(0, 0, 0));
            Font fonteNegrito = FontFactory.getFont(FontFactory.COURIER, 8.5f, Font.BOLD, new Color(255, 255, 255));

            Table tabela = new Table(Coluna);
            tabela.setBackgroundColor(new Color(0, 153, 255));
            tabela.setPadding(0.5f);
            tabela.setAlignment(Element.ALIGN_CENTER);
            tabela.setAlignment(Element.ALIGN_MIDDLE);
            tabela.setWidth(100f);
            tabela.setCellsFitPage(true);
            tabela.setBorderColor(new Color(0, 64, 136));

            // set um cabecalho
            Cell cabecalho = new Cell(new Paragraph(nomeArquivo));
            cabecalho.setHorizontalAlignment(Element.ALIGN_CENTER);
            cabecalho.setBackgroundColor(new Color(0, 64, 136));
            cabecalho.setColspan(Coluna);
            tabela.addCell(cabecalho);

            // coloca na tabela as colunas que estavam na JTable
            for (int col1 = 0; col1 < Coluna; col1++) {
                Cell coluna = new Cell(new Paragraph(XTabela.getColumnName(col1), fonteNegrito));
                coluna.setHorizontalAlignment(Element.ALIGN_CENTER);
                coluna.setBackgroundColor(new Color(0, 102, 255));
                coluna.setColspan(1);
                coluna.setBorderColor(new Color(0, 64, 136));
                tabela.addCell(coluna);
            }
            // coloca na tabela as linhas que estavam na JTable
            for (int lin = 0; lin < Linha; lin++) {
                for (int col2 = 0; col2 < Coluna; col2++) {
                    Cell celula = new Cell(new Paragraph(String.valueOf(XTabela.getValueAt(lin, col2)), fonteTexto));
                    celula.setHorizontalAlignment(Element.ALIGN_CENTER);
                    celula.setBorderColor(new Color(0, 64, 136));
                    tabela.addCell(celula);
                }
            }
            document.add(tabela);

        } catch (FileNotFoundException | DocumentException ex) {
            System.out.println(ex);
        } finally {
            document.close();
        }
    }
}

//        Document document = new Document(PageSize.A4, 50, 50, 50, 50);
//        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\Efraim\\Documents\\ITextTest.pdf"));
//        document.open();
//        document.add(new Paragraph("Ola mundo"));
//        document.add(new Paragraph("Teste de Fonte", FontFactory.getFont(FontFactory.TIMES, 14, Font.BOLD, new Color(255, 140, 132))));
//
//        Paragraph capitulo1 = new Paragraph("Titulo 1", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new Color(132, 243, 96)));
//        Chapter capitulo = new Chapter(capitulo1, 1);
//        capitulo.setNumberDepth(0);
//
//        Paragraph secao11 = new Paragraph("esta é seção 1, isto é o titulo da seção", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new Color(255, 0, 96)));
//        Section secao = capitulo.addSection(secao11);
//        Paragraph subSecao11 = new Paragraph("Aki vai o texto da secao", FontFactory.getFont(FontFactory.HELVETICA, 18, Font.BOLDITALIC, new Color(255, 0, 96)));
//        secao.add(subSecao11);
//        subSecao11 = new Paragraph("Tabela 3x2");
//        secao.add(subSecao11);
//
//        Table t = new Table(3, 2);
//        t.setBorderColor(new Color(220, 0, 0));
//        t.setPadding(5);//espaco dentro da celula
//        t.setSpacing(3);//espaco entre as celulas
//        t.setBorderWidth(1);
//        Cell c1 = new Cell("header1");
//        c1.setHeader(true);
//        t.addCell(c1);
//        c1 = new Cell("Header2");
//        t.addCell(c1);
//        c1 = new Cell("Header3");
//        t.addCell(c1);
//        t.endHeaders();
//        t.addCell("ola");
//        t.addCell("ola");
//        t.addCell("ola");
//        t.addCell("ola");
//        t.addCell("ola");
//        t.addCell("ola");
//        t.addCell("ola");
//        t.addCell("ola");
//        t.addCell("ola");
//        secao.add(t);
//        
//        List l = new List(true, false, 10);
//l.add(new ListItem("First item of list"));
//l.add(new ListItem("Second item of list"));
//secao.add(l);
//
//        document.add(capitulo);
//        document.close();
