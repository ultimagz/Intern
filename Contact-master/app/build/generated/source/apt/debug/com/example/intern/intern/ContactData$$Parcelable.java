
package com.example.intern.intern;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated(value = "org.parceler.ParcelAnnotationProcessor", date = "2016-07-12T14:05+0700")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class ContactData$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.intern.intern.ContactData>
{

    private com.example.intern.intern.ContactData contactData$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static ContactData$$Parcelable.Creator$$0 CREATOR = new ContactData$$Parcelable.Creator$$0();

    public ContactData$$Parcelable(com.example.intern.intern.ContactData contactData$$2) {
        contactData$$0 = contactData$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(contactData$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.example.intern.intern.ContactData contactData$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(contactData$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(contactData$$1));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "lastName_TH"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "fistName_TH"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "line"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "mobile"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "updateTime"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "nickName_EN"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "nickName_TH"));
            parcel$$1 .writeInt((contactData$$1 .isHeader? 1 : 0));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "lastName_EN"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "workphone"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "fistName_EN"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "_id"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "position"));
            parcel$$1 .writeString(contactData$$1 .value);
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.intern.intern.ContactData.class, contactData$$1, "email"));
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.intern.intern.ContactData getParcel() {
        return contactData$$0;
    }

    public static com.example.intern.intern.ContactData read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.example.intern.intern.ContactData contactData$$3;
            int reservation$$0 = identityMap$$1 .reserve();
            contactData$$3 = new com.example.intern.intern.ContactData();
            identityMap$$1 .put(reservation$$0, contactData$$3);
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "lastName_TH", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "fistName_TH", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "line", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "mobile", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "updateTime", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "nickName_EN", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "nickName_TH", parcel$$3 .readString());
            contactData$$3 .isHeader = (parcel$$3 .readInt() == 1);
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "lastName_EN", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "workphone", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "fistName_EN", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "_id", parcel$$3 .readString());
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "position", parcel$$3 .readString());
            contactData$$3 .value = parcel$$3 .readString();
            InjectionUtil.setField(com.example.intern.intern.ContactData.class, contactData$$3, "email", parcel$$3 .readString());
            return contactData$$3;
        }
    }

    public final static class Creator$$0
        implements Creator<ContactData$$Parcelable>
    {


        @Override
        public ContactData$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new ContactData$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public ContactData$$Parcelable[] newArray(int size) {
            return new ContactData$$Parcelable[size] ;
        }

    }

}
