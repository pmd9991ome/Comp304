package ziyuan.yang.s300868991.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YaHomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public YaHomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Ziyuan Yang");
    }

    public LiveData<String> getText() {
        return mText;
    }
}