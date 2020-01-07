/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tccc;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.TableColumnModelEvent;
import javax.swing.event.TableColumnModelListener;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.table.ColumnControlButton;
import org.jdesktop.swingx.table.TableColumnExt;

public class ControleDeColuna {

    private int columnValue = -1;
    private int columnNewValue = -1;

    public ControleDeColuna(JXTable Tbl, boolean control) {
        Tbl.packAll();
        Tbl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        Tbl.getColumnExt(0).setHideable(false);
        ColumnControlButton columnControl = new ColumnControlButton(Tbl) {
            @Override
            protected ColumnControlButton.ColumnVisibilityAction createColumnVisibilityAction(TableColumn column) {
                if (column instanceof TableColumnExt && !((TableColumnExt) column).isHideable()) {
                    return null;
                }
                return super.createColumnVisibilityAction(column);
            }
        };

        Tbl.setColumnControl(columnControl);
        Tbl.setColumnControlVisible(control);

        Tbl.getColumnModel().addColumnModelListener(new TableColumnModelListener() {

            public void columnAdded(TableColumnModelEvent e) {
            }

            public void columnMarginChanged(ChangeEvent e) {
            }

            public void columnMoved(TableColumnModelEvent e) {
                if (columnValue == -1) {
                    columnValue = e.getFromIndex();
                }
                columnNewValue = e.getToIndex();
            }

            public void columnRemoved(TableColumnModelEvent e) {
            }

            public void columnSelectionChanged(ListSelectionEvent e) {
            }
        }
        );
        Tbl.getTableHeader().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (columnValue != -1 && (columnValue == 0 || columnNewValue == 0)) {
                    Tbl.moveColumn(columnNewValue, columnValue);
                }
                columnValue = -1;
                columnNewValue = -1;
            }
        });

    }
}
