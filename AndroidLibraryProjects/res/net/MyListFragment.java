public class MyListFragment extends Fragment {

..// everything as before

    // triggers update of the details fragment                                 
    public void updateDetail(String uri) {  // #<1>
        List<RssItem> list = RssFeedProvider
                .parse("http://www.vogella.com/article.rss");
        String itemListAsString = String.valueOf(list.toString());
        listener.onRssItemSelected(itemListAsString);
    }
