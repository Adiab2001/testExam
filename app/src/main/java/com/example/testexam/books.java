package com.example.testexam;

import android.os.Parcel;
import android.os.Parcelable;

public class books implements Parcelable {
    String book,author,page;

    public books(String book, String author, String page) {
        this.book = book;
        this.author = author;
        this.page = page;
    }

    protected books(Parcel in) {
        book = in.readString();
        author = in.readString();
        page = in.readString();
    }

    public static final Creator<books> CREATOR = new Creator<books>() {
        @Override
        public books createFromParcel(Parcel in) {
            return new books(in);
        }

        @Override
        public books[] newArray(int size) {
            return new books[size];
        }
    };

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(book);
        parcel.writeString(author);
        parcel.writeString(page);
    }

    @Override
    public String toString() {
        return    "book='" + book + '\'' +", author='" + author + '\'' +
                ", page='" + page + '\'';
    }
}
