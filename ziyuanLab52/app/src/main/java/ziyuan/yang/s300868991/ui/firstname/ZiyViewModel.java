package ziyuan.yang.s300868991.ui.firstname;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ZiyViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ZiyViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("First Name: Ziyuan ");
    }

    public LiveData<String> getText() {
        return mText;
    }
}