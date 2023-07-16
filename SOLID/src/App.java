
public class App {
    public static void main(String[] args) throws Exception {
        // LSP test
        LSP lsp = new LSP();
        LSP.Quadrangle l0 = lsp.new Square(200,100);
        System.out.println(l0.area());

        LSP.Square l1 = lsp.new Square(0,0);
        l1.setSide(300);
        System.out.println(l1.area());

        LSP.Rectangle l2 = lsp.new Rectangle(0,0);
        l2.setHeight(200);
        l2.setWidth(400);
        System.out.println(l2.area());

    }
}
