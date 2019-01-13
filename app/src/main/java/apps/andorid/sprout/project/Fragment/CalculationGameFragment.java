package apps.andorid.sprout.project.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import apps.andorid.sprout.project.Data.CalculationGame;
import apps.andorid.sprout.project.R;

public class CalculationGameFragment extends Fragment {

    private TextView numberOfQuestionsTextView,
    correctWrongTextView, nextTextView,
    xTextView, operatorTextView,
    yTextView, answerTextView,
    answerOneTextView, answerTwoTextview,
            answerThreeTextView, answerFourTextView;

    private List<CalculationGame> gameData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_calculation_game, container, false);

        InitializeViews(view);

        gameData = new ArrayList<>();

//        for (int i = 0; i < 10; i++) {
//            gameData.add(getDummyGameData());
//        }

//        CalculationGame cg = new CalculationGame(
//                8,
//                4,
//                "+",
//                2,
//                3,
//                5,
//                6,
//                2,
//                1
//        );


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        CalculationGame cg = getDummyGameData();

        xTextView.setText(Integer.toString(cg.getX()));
        yTextView.setText(Integer.toString(cg.getY()));
        operatorTextView.setText(cg.getOperator());
        answerOneTextView.setText(Integer.toString(cg.getOptA()));
        answerTwoTextview.setText(Integer.toString(cg.getOptB()));
        answerThreeTextView.setText(Integer.toString(cg.getOptC()));
        answerFourTextView.setText(Integer.toString(cg.getOptD()));
    }

    private CalculationGame getDummyGameData() {

        ArrayList list = new ArrayList();

        //Creating object
        CalculationGame cg = new CalculationGame();

        //Generating Random numbers
        Random random = new Random();
        int operator = random.nextInt(2);
        int optionAnswerNumber = random.nextInt(4) + 1;

        for (int i = 0; i < 6; i++) {
            int x = Math.abs(random.nextInt(9) + 1);
            list.add(x);
        }

        //Adding data to object
        cg.setX(list.indexOf(0));
        cg.setY(list.indexOf(1));
        if (operator == 0) cg.setOperator("-");
        else cg.setOperator("+");

        cg.setAnswer(list.indexOf(0) + list.indexOf(1));

//        for (int i = 1; i <= 4; i++) {
//            if (i == optionAnswerNumber){
//                cg.setAnswer(list.indexOf(0) + list.indexOf(1));
//            } else {
//                switch (i) {
//                    case 1:
//                        cg.setOptA(list.indexOf(3));
//                    case 2:
//                        cg.setOptB(list.indexOf(4));
//                    case 3:
//                        cg.setOptC(list.indexOf(5));
//                    case 4:
//                        cg.setOptD(list.indexOf(6));
//                }
//            }
//        }

        cg.setOptA(8);
        cg.setOptB(9);
        cg.setOptC((list.indexOf(0) + list.indexOf(1)));
        cg.setOptD(10);

        cg.setQuestionNumber(1);

        return cg;

    }

    private void InitializeViews(View view) {
        numberOfQuestionsTextView = view.findViewById(R.id.numberOfQuestionsTextView);
        correctWrongTextView = view.findViewById(R.id.correctWrongTextView);
        nextTextView = view.findViewById(R.id.nextTextView);
        xTextView = view.findViewById(R.id.xTextView);
        yTextView = view.findViewById(R.id.yTextView);
        operatorTextView = view.findViewById(R.id.operatorTextView);
        answerTextView = view.findViewById(R.id.answerTextView);
        answerOneTextView = view.findViewById(R.id.answerOneTextView);
        answerTwoTextview = view.findViewById(R.id.answerTwoTextview);
        answerThreeTextView = view.findViewById(R.id.answerThereeTextView);
        answerFourTextView = view.findViewById(R.id.answerFourTextView);
    }
}
