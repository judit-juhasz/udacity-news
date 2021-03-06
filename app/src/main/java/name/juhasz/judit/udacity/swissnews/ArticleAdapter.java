package name.juhasz.judit.udacity.swissnews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ArticleAdapter extends ArrayAdapter<Article> {

    public ArticleAdapter(Context context, ArrayList<Article> articles) {
        super(context, 0, articles);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_article, parent, false);
        }

        Article currentArticle = getItem(position);

        ImageView coverImageView = (ImageView) listItemView.findViewById(R.id.iv_article_cover);
        Picasso.with(getContext())
                .load(currentArticle.getCoverImagePath())
                .placeholder(R.drawable.placeholder)
                .into(coverImageView);

        TextView articleTitleTextView = (TextView) listItemView.findViewById(R.id.tv_title_of_article);
        articleTitleTextView.setText(currentArticle.getTitle());

        TextView articleSectionTextView = (TextView) listItemView.findViewById(R.id.tv_section_of_article);
        articleSectionTextView.setText(currentArticle.getSectionName());

        return listItemView;
    }
}