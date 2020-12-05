package ziyuan.yang.s300868991.ui.lastname;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class YaSrvViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public YaSrvViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("Last Name: Yang");
    }

    public LiveData<String> getText() {
        return mText;
    }
}