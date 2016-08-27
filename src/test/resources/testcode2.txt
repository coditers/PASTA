package io.jaylim.algorithm;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.jaylim.algorithm.fielder.Fielder;
import io.jaylim.algorithm.player.Player;

/**
 * @author Jay Lim
 * @since 8/22/2016
 */
public class BestTeamBuilder implements ConstantsSet {

  // Initialization

  private List<List<Player>> skTotalEntries = new ArrayList<>();
  private List<List<Player>> nonSkTotalEntries = new ArrayList<>();

  public BestTeamBuilder(final List<Player> playerList) {
    for (int i = 0; i < 9; i++) {
      skTotalEntries.add(new ArrayList<>());
      nonSkTotalEntries.add(new ArrayList<>());
    }

    // sort to ascending order
    sortDescending(playerList);
    // classify sk and non-sk
    classifyPlayerList(playerList);
  }

  private void sortDescending(List<Player> totalEntries) {
    totalEntries.sort((Player p1, Player p2) -> (p2.getRating() - p1.getRating()));
  }

  private void classifyPlayerList(final List<Player> playerList) {
    for (Player player : playerList) {
      switch (player.getTeam()) {
        case TEAM_SK:
          initializePositionList(skTotalEntries, player);
          break;
        default:
          initializePositionList(nonSkTotalEntries, player);
          break;
      }
    }
  }

  private void initializePositionList(final List<List<Player>> playerLists, Player player) {
    if (player.isCatcherPos()) {
      playerLists.get(0).add(player);
    }
    if (player.isFirstBasemanPos()) {
      playerLists.get(1).add(player);
    }
    if (player.isSecondBasemanPos()) {
      playerLists.get(2).add(player);
    }
    if (player.isThirdBasemanPos()) {
      playerLists.get(3).add(player);
    }
    if (player.isShortStopPos()) {
      playerLists.get(4).add(player);
    }
    if (player.isRightFielderPos()) {
      playerLists.get(5).add(player);
    }
    if (player.isCenterFielderPos()) {
      playerLists.get(6).add(player);
    }
    if (player.isLeftFielderPos()) {
      playerLists.get(7).add(player);
    }
    if (player.isDesignatedHitterPos()) {
      playerLists.get(8).add(player);
    }
  }

  public Player[] findBestTeam(int skPlayerPosition) {
    boolean[] posBitMask = new boolean[9];

    int skCnt = 0;

    int positionMask = 0b000000001;
    for (int i = 0; i < posBitMask.length; i++) {
      if ((skPlayerPosition & positionMask) == positionMask) {
        posBitMask[i] = true;
        skCnt++;
      } else {
        posBitMask[i] = false;
      }
      positionMask = positionMask << 1;
    }

    int nonSkCnt = 9 - skCnt;
    if (skCnt < 3) {
      return null;
    }

    List<List<Player>> skCandidateEntries = new ArrayList<>();
    List<List<Player>> nonSkCandidateEntries = new ArrayList<>();

    for (int pos = 0; pos < 9; pos++) {
      if (posBitMask[pos]) {
        List<Player> skPartialEntries = skTotalEntries.get(pos);
        skCandidateEntries.add(skPartialEntries
            .subList(0, (skCnt < skPartialEntries.size()) ? skCnt : skPartialEntries.size()));
      } else {
        List<Player> nonSkPartialEntries = nonSkTotalEntries.get(pos);
        nonSkCandidateEntries.add(nonSkPartialEntries
            .subList(0, (nonSkCnt < nonSkPartialEntries.size()) ? nonSkCnt : nonSkPartialEntries.size()));
      }
    }


    findBestPartialTeam(0, new Player[skCnt], skCandidateEntries);
    Player[] skBestPlayer = Arrays.copyOf(partialBestEntries, partialBestEntries.length);


    findBestPartialTeam(0, new Player[nonSkCnt], nonSkCandidateEntries);
    Player[] nonSkBestPlayer = Arrays.copyOf(partialBestEntries, partialBestEntries.length);

    int skCnt2 = 0;
    int nonSkCnt2 = 0;

    Player[] localBestTeam = new Player[9];
    for (int pos = 0; pos < 9; pos++) {
      if (posBitMask[pos]) {
        Player skPlayer = skBestPlayer[skCnt2++];
        localBestTeam[pos] = skPlayer;
      } else {
        Player nonSkPlayer = nonSkBestPlayer[nonSkCnt2++];
        localBestTeam[pos] = nonSkPlayer;
      }
    }

    return localBestTeam;
  }


  private int partialMaxRating;
  private Player[] partialBestEntries;


  private void findBestPartialTeam(int pos, Player[] bestEntry, final List<List<Player>> candidatePool) {
    if (pos == 0) {
      partialMaxRating = 0;
      partialBestEntries = new Player[candidatePool.size()];
    }

    // Bound condition
    if (pos == candidatePool.size()) {

      int totalRating = 0;
      for (Player player : bestEntry) {
        totalRating += player.getRating();
      }

      if (totalRating >= partialMaxRating) {
        partialMaxRating = totalRating;
        partialBestEntries = Arrays.copyOf(bestEntry, bestEntry.length);
      }

      return;
    }

    for (Player player : candidatePool.get(pos)) {
      // delete redundancy
      if (isUnique(player, bestEntry)) {
        bestEntry[pos] = player;
      } else {
        continue;
      }

      findBestPartialTeam(pos + 1, bestEntry, candidatePool);
    }
  }

  private boolean isUnique(Player player, Player[] players) {
    for (Player selectedPlayer : players) {
      if (player == selectedPlayer) {
        return false;
      }
      if (selectedPlayer == null) {
        return true;
      }
    }
    return true;
  }

  public List<Fielder> findBestTeam() throws IOException {
    int globalSkCnt = 0;
    int globalMax = 0;
    Player[] globalBestPlayers = null;


    for (int defPositions = 0b000000000; defPositions <= 0b111111111; defPositions++) {
      Player[] localBestPlayers = findBestTeam(defPositions);

      int skCnt = 0;

      int positionMask = 0b000000001;
      for (int i = 0; i < 9; i++) {
        if ((defPositions & positionMask) == positionMask) {
          skCnt++;
        }
        positionMask = positionMask << 1;
      }

      int localMax = 0;

      if (skCnt == 9) {
        localMax += 36;
      } else if (skCnt >= 7) {
        localMax += skCnt * 2;
      } else if (skCnt >= 5) {
        localMax += skCnt;
      }

      if (localBestPlayers != null) {

        for (Player player : localBestPlayers) {
          if (player != null) {
            localMax += player.getRating();
          }
        }
      }

      if (globalMax < localMax) {
        globalMax = localMax;
        globalBestPlayers = localBestPlayers;
        globalSkCnt = skCnt;
      }

    }

    //If you want to generate description file {filename}.out.desc.txt, which provides information about
    //optimal solution, use this method.

    File file = new File(".\\src\\main\\resources\\player.out.desc.txt");

    PrintWriter printWriter = new PrintWriter(file);


    printWriter.println("======== OPTIMAL SOLUTION ========");

    printWriter.println("The number of sk player : " + globalSkCnt);
    printWriter.println("Total Rating : " + globalMax);

    printWriter.println("========== PLAYERS INFO ==========");

    for (Player player : globalBestPlayers) {
      printWriter.printf("%3s \t %3d \t %9s %6d\n", player.getName(), player.getRating(), String.format("%8s", Integer.toBinaryString(player.getDefPositions())).replace(' ', '0'), player.getDefPositions());
    }

    printWriter.println("==================================");

    printWriter.close();


    List<Fielder> fielderList = new ArrayList<>();

    int pos = 0b000000001;
    for (int i = 0; i < 9; i++) {
      fielderList.add(new Fielder(globalBestPlayers[i], i + 1, pos));
      pos <<= 1;
    }

    return fielderList;
  }

}
