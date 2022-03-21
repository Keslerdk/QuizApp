package com.example.quizapp.databinding;
import com.example.quizapp.R;
import com.example.quizapp.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentQuestionsBindingImpl extends FragmentQuestionsBinding implements com.example.quizapp.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = new androidx.databinding.ViewDataBinding.IncludedLayouts(7);
        sIncludes.setIncludes(0, 
            new String[] {"bottom_sheet"},
            new int[] {3},
            new int[] {com.example.quizapp.R.layout.bottom_sheet});
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.question_num, 4);
        sViewsWithIds.put(R.id.question_text, 5);
        sViewsWithIds.put(R.id.answer_list, 6);
    }
    // views
    @NonNull
    private final androidx.coordinatorlayout.widget.CoordinatorLayout mboundView0;
    @NonNull
    private final com.facebook.shimmer.ShimmerFrameLayout mboundView2;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentQuestionsBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentQuestionsBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (androidx.recyclerview.widget.RecyclerView) bindings[6]
            , (android.widget.Button) bindings[1]
            , (com.example.quizapp.databinding.BottomSheetBinding) bindings[3]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[5]
            );
        this.button.setTag(null);
        setContainedBinding(this.included);
        this.mboundView0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (com.facebook.shimmer.ShimmerFrameLayout) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.quizapp.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        included.invalidateAll();
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        if (included.hasPendingBindings()) {
            return true;
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.fragment == variableId) {
            setFragment((com.example.quizapp.ui.fragments.QuestionsFragment) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.example.quizapp.ui.viewmodels.QuestionsViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setFragment(@Nullable com.example.quizapp.ui.fragments.QuestionsFragment Fragment) {
        this.mFragment = Fragment;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.fragment);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.example.quizapp.ui.viewmodels.QuestionsViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    public void setLifecycleOwner(@Nullable androidx.lifecycle.LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        included.setLifecycleOwner(lifecycleOwner);
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeIncluded((com.example.quizapp.databinding.BottomSheetBinding) object, fieldId);
            case 1 :
                return onChangeViewModelStatus((androidx.lifecycle.LiveData<com.example.quizapp.ui.viewmodels.Status>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeIncluded(com.example.quizapp.databinding.BottomSheetBinding Included, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelStatus(androidx.lifecycle.LiveData<com.example.quizapp.ui.viewmodels.Status> ViewModelStatus, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        com.example.quizapp.ui.fragments.QuestionsFragment fragment = mFragment;
        androidx.lifecycle.LiveData<com.example.quizapp.ui.viewmodels.Status> viewModelStatus = null;
        com.example.quizapp.ui.viewmodels.Status viewModelStatusGetValue = null;
        com.example.quizapp.ui.viewmodels.QuestionsViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1aL) != 0) {



                if (viewModel != null) {
                    // read viewModel.status
                    viewModelStatus = viewModel.getStatus();
                }
                updateLiveDataRegistration(1, viewModelStatus);


                if (viewModelStatus != null) {
                    // read viewModel.status.getValue()
                    viewModelStatusGetValue = viewModelStatus.getValue();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.button.setOnClickListener(mCallback1);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            com.example.quizapp.BindingAdapterKt.bindLoading(this.mboundView2, viewModelStatusGetValue);
        }
        executeBindingsOn(included);
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // fragment
        com.example.quizapp.ui.fragments.QuestionsFragment fragment = mFragment;
        // fragment != null
        boolean fragmentJavaLangObjectNull = false;



        fragmentJavaLangObjectNull = (fragment) != (null);
        if (fragmentJavaLangObjectNull) {


            fragment.checkTheAnswer();
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): included
        flag 1 (0x2L): viewModel.status
        flag 2 (0x3L): fragment
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}