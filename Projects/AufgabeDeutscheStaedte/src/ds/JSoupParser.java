package ds;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSoupParser implements Parser {

    @Override
    public List<Stadt> parse(String text) {
        List<Stadt> list = new ArrayList<>();
        
        Document doc = Jsoup.parse(text);
        
//        System.out.println(text);

        Elements alleTabellen = doc.getElementsByTag("table");
        Element tabelle = alleTabellen.get(0);
        
        Elements alleZeilen = tabelle.getElementsByTag("tr");
        
        for (int i = 2; i < alleZeilen.size()-2; i++) {
            Element zeile = alleZeilen.get(i);
            
            Stadt s = parse(zeile);
            list.add(s);
        }
        
        return list;
    }

    private Stadt parse(Element zeile) {
        
//        System.out.println(zeile);
        Elements alleSpalten = zeile.getElementsByTag("td");
        
        Element spalteName = alleSpalten.get(1);
        Element anchorMitNamen = spalteName.getElementsByTag("a").first();
        String name = anchorMitNamen.text();
        
        Element spalteEinwohner = alleSpalten.get(10);
        String einwohnerText = spalteEinwohner.ownText();
        einwohnerText = einwohnerText.replace(".", "");
        
        int einwohner = Integer.parseInt(einwohnerText);
        
        Element spalteLand = alleSpalten.get(15);
        Element anchorMitLand = spalteLand.getElementsByTag("a").last();
        String land = anchorMitLand.text();
        
        return new Stadt(name, land, einwohner);
    }
    
}
