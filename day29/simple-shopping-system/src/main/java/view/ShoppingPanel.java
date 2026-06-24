package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.math.BigDecimal;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.ShoppingController;
import model.CartItem;
import model.Member;
import model.Product;

public class ShoppingPanel extends JPanel {
    private static final long serialVersionUID = 1L;

    private final Member loginMember;
    private final ShoppingController shoppingController = new ShoppingController();
    private final DefaultTableModel productModel = new DefaultTableModel(
            new Object[] { "商品ID", "商品名稱", "價格", "庫存", "說明" }, 0);
    private final DefaultTableModel cartModel = new DefaultTableModel(
            new Object[] { "購物ID", "商品ID", "商品名稱", "單價", "數量", "小計" }, 0);

    private JTable productTable;
    private JTable cartTable;
    private JTextField productNameField;
    private JTextField priceField;
    private JTextField stockField;
    private JTextField descriptionField;
    private JTextField quantityField;
    private JLabel totalLabel;
    private Integer selectedProductId;
    private Integer selectedCartItemId;

    public ShoppingPanel(Member loginMember) {
        this.loginMember = loginMember;
        setLayout(new BorderLayout(10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        splitPane.setResizeWeight(0.5);
        add(splitPane, BorderLayout.CENTER);

        splitPane.setTopComponent(createProductPanel());
        splitPane.setBottomComponent(createCartPanel());

        reloadProducts();
        reloadCart();
    }

    private JPanel createProductPanel() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.add(new JLabel("商品 CRUD"), BorderLayout.NORTH);

        productTable = new JTable(productModel);
        panel.add(new JScrollPane(productTable), BorderLayout.CENTER);

        JPanel formPanel = new JPanel(new GridLayout(2, 8, 4, 4));
        productNameField = new JTextField();
        priceField = new JTextField();
        stockField = new JTextField();
        descriptionField = new JTextField();
        quantityField = new JTextField("1");

        JButton createButton = new JButton("新增商品");
        JButton updateButton = new JButton("修改商品");
        JButton deleteButton = new JButton("刪除商品");
        JButton addCartButton = new JButton("加入購物車");

        formPanel.add(new JLabel("名稱"));
        formPanel.add(new JLabel("價格"));
        formPanel.add(new JLabel("庫存"));
        formPanel.add(new JLabel("說明"));
        formPanel.add(new JLabel("購買數量"));
        formPanel.add(new JLabel(""));
        formPanel.add(new JLabel(""));
        formPanel.add(new JLabel(""));
        formPanel.add(productNameField);
        formPanel.add(priceField);
        formPanel.add(stockField);
        formPanel.add(descriptionField);
        formPanel.add(quantityField);
        formPanel.add(createButton);
        formPanel.add(updateButton);
        formPanel.add(deleteButton);

        JPanel southPanel = new JPanel(new BorderLayout());
        southPanel.add(formPanel, BorderLayout.CENTER);
        southPanel.add(addCartButton, BorderLayout.EAST);
        panel.add(southPanel, BorderLayout.SOUTH);

        productTable.getSelectionModel().addListSelectionListener(e -> loadSelectedProduct());
        createButton.addActionListener(e -> createProduct());
        updateButton.addActionListener(e -> updateProduct());
        deleteButton.addActionListener(e -> deleteProduct());
        addCartButton.addActionListener(e -> addToCart());

        return panel;
    }

    private JPanel createCartPanel() {
        JPanel panel = new JPanel(new BorderLayout(8, 8));
        panel.add(new JLabel("購物車 CRUD"), BorderLayout.NORTH);

        cartTable = new JTable(cartModel);
        panel.add(new JScrollPane(cartTable), BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 4, 4));
        JButton updateQtyButton = new JButton("修改購物數量");
        JButton deleteItemButton = new JButton("刪除購物項目");
        JButton checkoutButton = new JButton("結帳清空購物車");
        JButton reloadButton = new JButton("重新整理");
        totalLabel = new JLabel("總金額：0");

        buttonPanel.add(updateQtyButton);
        buttonPanel.add(deleteItemButton);
        buttonPanel.add(checkoutButton);
        buttonPanel.add(reloadButton);
        buttonPanel.add(totalLabel);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        cartTable.getSelectionModel().addListSelectionListener(e -> loadSelectedCartItem());
        updateQtyButton.addActionListener(e -> updateCartQuantity());
        deleteItemButton.addActionListener(e -> deleteCartItem());
        checkoutButton.addActionListener(e -> checkout());
        reloadButton.addActionListener(e -> reloadAll());

        return panel;
    }

    private void reloadAll() {
        reloadProducts();
        reloadCart();
    }

    private void reloadProducts() {
        productModel.setRowCount(0);
        List<Product> products = shoppingController.findAllProducts();
        for (Product product : products) {
            productModel.addRow(new Object[] {
                    product.getId(),
                    product.getName(),
                    product.getPrice(),
                    product.getStock(),
                    product.getDescription()
            });
        }
    }

    private void reloadCart() {
        cartModel.setRowCount(0);
        List<CartItem> items = shoppingController.findCart(loginMember.getId());
        for (CartItem item : items) {
            cartModel.addRow(new Object[] {
                    item.getId(),
                    item.getProductId(),
                    item.getProductName(),
                    item.getPrice(),
                    item.getQuantity(),
                    item.getSubtotal()
            });
        }
        totalLabel.setText("總金額：" + shoppingController.calculateTotal(loginMember.getId()));
    }

    private void loadSelectedProduct() {
        int row = productTable.getSelectedRow();
        if (row < 0) {
            return;
        }
        selectedProductId = (Integer) productModel.getValueAt(row, 0);
        productNameField.setText(String.valueOf(productModel.getValueAt(row, 1)));
        priceField.setText(String.valueOf(productModel.getValueAt(row, 2)));
        stockField.setText(String.valueOf(productModel.getValueAt(row, 3)));
        descriptionField.setText(String.valueOf(productModel.getValueAt(row, 4)));
    }

    private void loadSelectedCartItem() {
        int row = cartTable.getSelectedRow();
        if (row < 0) {
            return;
        }
        selectedCartItemId = (Integer) cartModel.getValueAt(row, 0);
        quantityField.setText(String.valueOf(cartModel.getValueAt(row, 4)));
    }

    private Product readProductForm() {
        Product product = new Product();
        product.setId(selectedProductId);
        product.setName(productNameField.getText());
        product.setPrice(new BigDecimal(priceField.getText().trim()));
        product.setStock(Integer.parseInt(stockField.getText().trim()));
        product.setDescription(descriptionField.getText());
        return product;
    }

    private Integer readQuantity() {
        return Integer.parseInt(quantityField.getText().trim());
    }

    private void createProduct() {
        try {
            shoppingController.createProduct(readProductForm());
            reloadProducts();
            clearProductForm();
            showMessage("新增商品成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void updateProduct() {
        try {
            shoppingController.updateProduct(readProductForm());
            reloadProducts();
            clearProductForm();
            showMessage("修改商品成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void deleteProduct() {
        try {
            shoppingController.deleteProduct(selectedProductId);
            reloadProducts();
            clearProductForm();
            showMessage("刪除商品成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void addToCart() {
        try {
            shoppingController.addToCart(loginMember.getId(), selectedProductId, readQuantity());
            reloadCart();
            showMessage("加入購物車成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void updateCartQuantity() {
        try {
            shoppingController.updateCartQuantity(selectedCartItemId, readQuantity());
            reloadCart();
            showMessage("修改購物數量成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void deleteCartItem() {
        try {
            shoppingController.deleteCartItem(selectedCartItemId);
            reloadCart();
            showMessage("刪除購物項目成功");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void checkout() {
        try {
            shoppingController.checkout(loginMember.getId());
            reloadCart();
            showMessage("結帳完成，購物車已清空");
        } catch (RuntimeException ex) {
            showError(ex);
        }
    }

    private void clearProductForm() {
        selectedProductId = null;
        productNameField.setText("");
        priceField.setText("");
        stockField.setText("");
        descriptionField.setText("");
        quantityField.setText("1");
        productTable.clearSelection();
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    private void showError(RuntimeException ex) {
        JOptionPane.showMessageDialog(this, ex.getMessage(), "錯誤", JOptionPane.ERROR_MESSAGE);
    }
}
