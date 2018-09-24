package com.doordash.discovery.doordashdiscovery.ui.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.doordash.discovery.doordashdiscovery.R;
import com.doordash.discovery.doordashdiscovery.model.Restaurant;
import com.doordash.discovery.doordashdiscovery.network.IGetRestaurantListService;
import com.doordash.discovery.doordashdiscovery.network.RestaurantListClientInstance;
import com.doordash.discovery.doordashdiscovery.ui.adapters.DiscoveryListAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * This activity shows the user a list of restaurants close to Doordash HQ,
 * along with basic details of each restaurant
 */
public class RestaurantDiscoveryActivity extends AppCompatActivity {
    private static final double DOORDASH_HQ_LAT = 37.422740;
    private static final double DOORDASH_HQ_LNG = -122.139956;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_activity_restaurant_discovery);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getString(R.string.progress_dialog_loading));
        mProgressDialog.show();

        fetchRestaurantListFromServer();

    }

    private void fetchRestaurantListFromServer() {
        IGetRestaurantListService service = RestaurantListClientInstance.getRetrofitInstance().create(IGetRestaurantListService.class);
        Call<List<Restaurant>> call = service.getRestaurantList(DOORDASH_HQ_LAT, DOORDASH_HQ_LNG,
                IGetRestaurantListService.DEFAULT_OFFSET, IGetRestaurantListService.DEFAULT_LIMIT);
        call.enqueue(new Callback<List<Restaurant>>() {
            @Override
            public void onResponse(Call<List<Restaurant>> call, Response<List<Restaurant>> response) {
                mProgressDialog.dismiss();
                setupRestaurantListRecyclerView(response.body());
            }

            @Override
            public void onFailure(Call<List<Restaurant>> call, Throwable t) {
                mProgressDialog.dismiss();
                Toast.makeText(RestaurantDiscoveryActivity.this, getString(R.string.error_service_failure), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRestaurantListRecyclerView(@Nullable List<Restaurant> restaurantList) {
        if (null != restaurantList && !restaurantList.isEmpty()) {
            RecyclerView recyclerView = findViewById(R.id.restaurant_list_recycler_view);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
            DiscoveryListAdapter adapter = new DiscoveryListAdapter(restaurantList);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
            recyclerView.setAdapter(adapter);
        }
    }
}
